package spellcasting.nightside.mana;

import com.google.gson.annotations.Expose;

public class StorePlayerData_Mana
{
	@Expose
	private int currentMana = 100;
	@Expose
	private int maxMana = 100;
	@Expose
	private int minMana = 0;
	
	public int getCurrentMana()
	{
		return currentMana;
	}

	public void setCurrentMana(int currentMana)
	{
		this.currentMana = currentMana;
	}

	public int getMaxMana()
	{
		return maxMana;
	}

	public void setMaxMana(int maxMana)
	{
		this.maxMana = maxMana;
	}

	public int getMinMana()
	{
		return minMana;
	}

	public void setMinMana(int minMana)
	{
		this.minMana = minMana;
	}	

}
