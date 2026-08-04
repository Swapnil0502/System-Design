package Splitwise.factory;

import Splitwise.enums.SplitType;
import Splitwise.strategy.EqualSplitStrategy;
import Splitwise.strategy.PercentageSplitStrategy;
import Splitwise.strategy.SplitStrategy;
import Splitwise.strategy.ExactSplitStrategy;

public class SplitStrategyFactory {

    public SplitStrategy getSplitTypeObject(SplitType splitType) {
        if (splitType.equals(splitType.valueOf("EXACT"))) {
            return new ExactSplitStrategy();
        } else if (splitType.equals(splitType.valueOf("EQUAL"))) {
            return new EqualSplitStrategy();
        } else if (splitType.equals(splitType.valueOf("PERCENTAGE"))) {
            return new PercentageSplitStrategy();
        } else
            throw new IllegalArgumentException("Invalid SplitStrategy");
    }
}