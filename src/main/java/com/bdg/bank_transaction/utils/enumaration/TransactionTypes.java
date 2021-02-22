package com.bdg.bank_transaction.utils.enumaration;

public enum TransactionTypes {
    DEPOSIT(1){
        public String toString(){
            return "id: 1, type: DEPOSIT";
        }
    },

    WITHDRAWAL(2){
        public String toString(){
            return "id: 2, type: WITHDRAWAL";
        }
    };
    private int id;
    TransactionTypes(int id) {
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public static TransactionTypes getById(int id){
        for(TransactionTypes type : values()) {
            if(type.id == (id))
                return type;
        }

        return null;
    }

}
