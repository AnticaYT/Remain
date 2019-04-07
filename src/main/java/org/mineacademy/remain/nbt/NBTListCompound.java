package org.mineacademy.remain.nbt;

import java.util.HashSet;
import java.util.Set;

import org.mineacademy.remain.util.MinecraftVersion;
import org.mineacademy.remain.util.MinecraftVersion.V;

/**
 * Represents a list compounnd NBT tag
 */
public class NBTListCompound {

	private final NBTList owner;
	private final Object compound;

	protected NBTListCompound(NBTList parent, Object obj) {
		owner = parent;
		compound = obj;
	}

	public void setString(String key, String val) {
		if (val == null) {
			remove(key);
			return;
		}
		try {
			compound.getClass().getMethod("setString", String.class, String.class).invoke(compound, key, val);
			owner.save();
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setInteger(String key, int val) {
		try {
			compound.getClass().getMethod("setInt", String.class, int.class).invoke(compound, key, val);
			owner.save();
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}

	public int getInteger(String key) {
		try {
			return (int) compound.getClass().getMethod("getInt", String.class).invoke(compound, key);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public void setDouble(String key, double val) {
		try {
			compound.getClass().getMethod("setDouble", String.class, double.class).invoke(compound, key, val);
			owner.save();
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}

	public double getDouble(String key) {
		try {
			return (double) compound.getClass().getMethod("getDouble", String.class).invoke(compound, key);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public String getString(String key) {
		try {
			return (String) compound.getClass().getMethod("getString", String.class).invoke(compound, key);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public boolean hasKey(String key) {
		try {
			return (boolean) compound.getClass().getMethod("hasKey", String.class).invoke(compound, key);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	
	public Set<String> getKeys() {
		try {
			return (Set<String>) compound.getClass().getMethod(MinecraftVersion.atLeast(V.v1_13) ? "getKeys" : "c").invoke(compound);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return new HashSet<>();
	}

	public void remove(String key) {
		try {
			compound.getClass().getMethod("remove", String.class).invoke(compound, key);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}

}
