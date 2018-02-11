package test;
public enum Month{
        JANUARY (31),
        FEBRUARY (27),
        MARCH (31),
        APRIL (30),
        MAY (31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);
        
        private final int numDays;
        
        Month(int numDays){
            this.numDays = numDays;
        }
        
        public int numberOfDays(){ return this.numDays;}
        
    }
