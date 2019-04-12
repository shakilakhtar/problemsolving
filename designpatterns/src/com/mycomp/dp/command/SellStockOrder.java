package com.mycomp.dp.command;

//ConcreteCommand Class.
public class SellStockOrder implements Order{

    private StockTrade stock;
    public SellStockOrder ( StockTrade st) {
        stock = st;
    }
    public void execute(Object request) {
        stock . sell( );
    }
}
