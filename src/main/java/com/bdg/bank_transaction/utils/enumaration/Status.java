package com.bdg.bank_transaction.utils.enumaration;

public enum Status {
    PENDING(1){
        public String toString(){
            return "id: 1, status: pending";
        }
    },

    ACCEPTED(2){
        public String toString(){
            return "id: 2, status: accepted";
        }
    },

    CANCELED(3){
        public String toString(){
            return "id: 3, status: canceled";
        }
    };


    private int id;
    Status(int id) {
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public static Status getById(int id){
        for(Status type : values()) {
            if(type.id == (id))
                return type;
        }

        return null;
    }

}
