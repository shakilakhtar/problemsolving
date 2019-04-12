package com.mycomp.dp.command;

//ConcreteCommand Class.
public class BuyStockOrder implements Order{

    private StockTrade stock;
    public BuyStockOrder ( StockTrade st) {
        stock = st;
    }
    public void execute(Object request) {
        stock . buy( );
    }
}
