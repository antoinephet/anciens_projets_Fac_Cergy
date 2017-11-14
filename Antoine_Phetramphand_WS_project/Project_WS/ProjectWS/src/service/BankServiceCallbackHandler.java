
/**
 * BankServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package service;

    /**
     *  BankServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class BankServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public BankServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public BankServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getAccounts method
            * override this method for handling normal response from getAccounts operation
            */
           public void receiveResultgetAccounts(
                    service.BankServiceStub.GetAccountsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAccounts operation
           */
            public void receiveErrorgetAccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for conversion method
            * override this method for handling normal response from conversion operation
            */
           public void receiveResultconversion(
                    service.BankServiceStub.ConversionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from conversion operation
           */
            public void receiveErrorconversion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for list method
            * override this method for handling normal response from list operation
            */
           public void receiveResultlist(
                    service.BankServiceStub.ListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from list operation
           */
            public void receiveErrorlist(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for message method
            * override this method for handling normal response from message operation
            */
           public void receiveResultmessage(
                    service.BankServiceStub.MessageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from message operation
           */
            public void receiveErrormessage(java.lang.Exception e) {
            }
                


    }
    