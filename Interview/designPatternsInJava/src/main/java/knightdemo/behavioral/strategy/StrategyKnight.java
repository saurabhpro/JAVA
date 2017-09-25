package knightdemo.behavioral.strategy;

import knightdemo.model.Knight;

public interface StrategyKnight extends Knight {

	void setStrategy(Strategy strategy);

}
