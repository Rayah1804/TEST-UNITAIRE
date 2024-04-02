package fr.emse.test;
public class Money implements IMoney{
	private int fAmount;
	private String fCurrency;
	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}
	
	
	@Override
    public boolean isSameCurrency(IMoney money) {
        return money instanceof Money && ((Money) money).currency().equals(currency());
    }

    @Override
    public IMoney add(IMoney money) {
        if (isSameCurrency(money)) {
            Money m = (Money) money;
            return new Money(amount() + m.amount(), currency());
        } else {
            return new MoneyBag(this, (Money) money);
        }
    }

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Money other = (Money) obj;
	    return fAmount == other.fAmount && fCurrency.equals(other.fCurrency);
	}
	//-----------------------------------------------------------------------------

	public int amount() {
		return fAmount;
	}
	public String currency() {
		return fCurrency;
	}
	public Money add(Money m) {
		return new Money(amount() + m.amount(), currency());
	}
}