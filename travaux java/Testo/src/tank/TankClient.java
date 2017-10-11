//TankClient.java

package tank;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



@SuppressWarnings("serial")
public class TankClient extends Frame {

	static final int GAME_WIDTH = 800;
	static final int GAME_HEIGHT = 600;
	private int x = 50;
	private int y = 50;
	private int refreshTime = 16;
	private int bloodTime = 500;
	private int bloodStep = 0;
	private int maxBloods = 10;
	private int minTanks = 3;
	private int maxTanks = 20;
	private Image bufImg = null;
	private Color bgColor = Color.GREEN;
	private boolean hasGetdist = false;
	private int disX = 0;
	private int disY = 0;
	private int enemyNum = 10;
	private static Random rand = new Random();
	private boolean start = false;
	private int score = 0;
	private int killPoint = 5;

	private List<Explode> explodes = new ArrayList<Explode>();
	private List<Tank> tanks = new ArrayList<Tank>();
	private List<Missile> missiles = new ArrayList<Missile>();
	private List<Wall> walls = new ArrayList<Wall>();
	private List<Blood> bloods = new ArrayList<Blood>();

	
	
	public void launchFrame() {
		this.setTitle("TankWar");
		this.setLocation(300, 300);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		this.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				hasGetdist = false;
			}

		});
		this.addMouseMotionListener(new MouseAdapter() {

			public void mouseDragged(MouseEvent e) {

				if (!hasGetdist) {
					disX = e.getX();
					disY = e.getY();
					hasGetdist = true;
				}
				setLocation(e.getXOnScreen() - disX, e.getYOnScreen() - disY);
			}

		});
		this.setBackground(bgColor);
		this.addKeyListener(new KeyMonitor());
		this.setVisible(true);
		gameInit();
	}
	
	private void gameInit() {
		tanks.add(new Tank(x, y, true, this));
		addTank(10);
		walls.add(new Wall(300, 400, 300, 30));
		walls.add(new Wall(400, 300, 10, 200));
		score = 0;
		start = true;
	}

	// 重写paint方法

	private void addBlood() {
		bloodStep++;
		if (bloodStep >= bloodTime && bloods.size() < maxBloods) {
			bloodStep = 0;
			Blood blood = new Blood(x, y);
			blood.setX(rand.nextInt(GAME_WIDTH - blood.getSize()));
			blood.setY(rand.nextInt(GAME_HEIGHT - blood.getSize() - 25) + 25);
			for (int i = 0; i < tanks.size(); i++)
				if (blood.getRect().intersects(tanks.get(i).getRect()))
					return;
			for (int i = 0; i < walls.size(); i++)
				if (blood.getRect().intersects(walls.get(i).getRect()))
					return;
			for (int i = 0; i < bloods.size(); i++)
				if (blood.getRect().intersects(bloods.get(i).getRect()))
					return;
			bloods.add(blood);
		}
	}

	
	public void paint(Graphics g) {
		if (start) {
			addBlood();
			g.drawString("MissilesCount : " + missiles.size(), 10, 40);
			g.drawString("ExplodeCount : " + explodes.size(), 10, 50);
			g.drawString("TanksCount : " + (tanks.size()), 10, 60);
			g.drawString("WallsCount : " + walls.size(), 10, 70);
			g.drawString("BloodsCount : " + bloods.size(), 10, 80);
			g.drawString("Score : " + score, 10, 100);
			for (int i = 0; i < explodes.size(); i++)
				explodes.get(i).draw(g);
			for (int i = 0; i < missiles.size(); i++) {
				Missile missile = missiles.get(i);
				for (int j = 0; j < walls.size(); j++) {
					Wall w = walls.get(j);
					if (missile.hitWall(w))
						missiles.remove(missile);
				}
				for (int k = 0; k < tanks.size(); k++) {
					Tank tank = tanks.get(k);
					if (missiles.contains(missile) && missile.hitTank(tank)) {
						missiles.remove(missile);
						int life = tank.getLife() - missile.getAttackHurt();
						if (life <= 0) {
							score += killPoint;
							tanks.remove(tank);
							explodes.add(new Explode(tank.getX()
									+ tank.getSize() / 2, tank.getY()
									+ tank.getSize() / 2, this));
							if (tank.isGood())
								gameOver();
						} else {
							tank.setLife(life);
						}
					}
				}
			}
			for (int i = 0; i < tanks.size(); i++) {
				Tank t = tanks.get(i);
				t.draw(g);
				if (t.isGood())
					g.drawString("TankLife : " + t.getLife(), 10, 90);
				for (int j = 0; j < bloods.size(); j++) {
					Blood blood = bloods.get(j);
					if (blood.getRect().intersects(t.getRect())) {
						bloods.remove(blood);
						t.setLife(t.getLife() + blood.getBlood());
					}
				}
			}
			for (int i = 0; i < missiles.size(); i++)
				missiles.get(i).draw(g);
			for (int i = 0; i < walls.size(); i++)
				walls.get(i).draw(g);
			for (int i = 0; i < bloods.size(); i++)
				bloods.get(i).draw(g);
			if(tanks.size()<minTanks)
				addTank(maxTanks-tanks.size());
		} else {
			g.drawString("GAME OVER", 10, 40);
			g.drawString("SCORE : " + score, 10, 60);
			g.drawString("PRESS F2 TO RESTART", 10, 80);
		}
	}

	private void gameOver() {
		tanks.clear();
		missiles.clear();
		bloods.clear();
		walls.clear();
		start = false;
	}

	

	public void update(Graphics g) {

		if (bufImg == null)
			
			bufImg = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		
		Graphics gBufImg = bufImg.getGraphics();
		
		Color c = gBufImg.getColor();
		
		gBufImg.setColor(bgColor);
		gBufImg.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		
		gBufImg.setColor(c);

		paint(gBufImg);
		
		g.drawImage(bufImg, 0, 0, null);
	}

	// 运行线程

	private class PaintThread implements Runnable {

		public void run() {
			while (true) {
				try {
					Thread.sleep(refreshTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
		}

	}

	// 添加键盘监听器类

	private class KeyMonitor extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			if (start) {
				for (int i = 0; i < tanks.size(); i++) {
					tanks.get(i).keyReleased(e.getKeyCode());
				}
			}
		}

		public void keyPressed(KeyEvent e) {
			if (start) {
				for (int i = 0; i < tanks.size(); i++) {
					tanks.get(i).keyPressed(e.getKeyCode());
				}

				if (e.getKeyCode() == KeyEvent.VK_EQUALS) {
					addTank(1);
				}
			}
			if (!start && e.getKeyCode() == KeyEvent.VK_F2) {
				gameInit();
				start = true;
			}

		}
	}
	
	private void addTank(int tankNum){
		while(true&&tankNum>0){
			boolean addAble=true;
			Tank t = new Tank(x, y, false, TankClient.this);
			t.setX(rand.nextInt(GAME_WIDTH - t.getSize()));
			t.setY(rand.nextInt(GAME_HEIGHT - t.getSize() - 25) + 25);
			for (int i = 0; i < tanks.size(); i++)
				if (t.getRect().intersects(tanks.get(i).getRect())){
					addAble=false;
					break;
				}
			for (int i = 0; i < walls.size(); i++)
				if (t.getRect().intersects(walls.get(i).getRect())){
					addAble=false;
					break;
				}
			if(addAble){
				tanks.add(t);
				tankNum--;	
			}
		}
	}

	

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.launchFrame();
		new Thread(tc.new PaintThread()).start();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(int refreshTime) {
		this.refreshTime = refreshTime;
	}

	public Image getBufImg() {
		return bufImg;
	}

	public void setBufImg(Image bufImg) {
		this.bufImg = bufImg;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public boolean isHasGetdist() {
		return hasGetdist;
	}

	public void setHasGetdist(boolean hasGetdist) {
		this.hasGetdist = hasGetdist;
	}

	public int getDisX() {
		return disX;
	}

	public void setDisX(int disX) {
		this.disX = disX;
	}

	public int getDisY() {
		return disY;
	}

	public void setDisY(int disY) {
		this.disY = disY;
	}

	public List<Explode> getExplodes() {
		return explodes;
	}

	public void setExplodes(List<Explode> explodes) {
		this.explodes = explodes;
	}

	public List<Tank> getTanks() {
		return tanks;
	}

	public void setTanks(List<Tank> tanks) {
		this.tanks = tanks;
	}

	public List<Missile> getMissiles() {
		return missiles;
	}

	public void setMissiles(List<Missile> missiles) {
		this.missiles = missiles;
	}

	public int getEnemyNum() {
		return enemyNum;
	}

	public void setEnemyNum(int enemyNum) {
		this.enemyNum = enemyNum;
	}
	public List<Wall> getWalls() {
		return walls;
	}

	public void setWalls(List<Wall> walls) {
		this.walls = walls;
	}


}
