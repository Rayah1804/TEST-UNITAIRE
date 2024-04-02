package fr.emse.test;

public interface IMoney {
    boolean isSameCurrency(IMoney money);
    IMoney add(IMoney money);
}
