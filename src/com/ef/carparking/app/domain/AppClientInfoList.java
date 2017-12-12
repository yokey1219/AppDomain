package com.ef.carparking.app.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AppClientInfoList implements Collection<AppClientInfo>,Iterable<AppClientInfo> {

	protected Map<String,AppClientInfo> internalmap;
	
	public AppClientInfoList()
	{
		internalmap=new HashMap<String,AppClientInfo>();
	}

	@Override
	public boolean add(AppClientInfo e) {
		try
		{
			this.internalmap.put(e.sn, e);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public boolean addAll(Collection<? extends AppClientInfo> c) {
		for(AppClientInfo info:c)
		{
			this.add(info);
		}
		return true;
	}

	@Override
	public void clear() {
		this.internalmap.clear();
		
	}

	@Override
	public boolean contains(Object o) {
		if(o instanceof AppClientInfo)
		{
			return this.internalmap.containsKey(((AppClientInfo) o).id);
		}
		else
			return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean flag=true;
		for(Object o:c)
			flag=flag&&this.contains(o);
		return flag;
	}

	@Override
	public boolean isEmpty() {
		
		return this.internalmap.isEmpty();
	}

	@Override
	public Iterator<AppClientInfo> iterator() {
		return this.internalmap.values().iterator();
	}

	@Override
	public boolean remove(Object o) {
		if(this.contains(o))
		{
			this.internalmap.remove(((AppClientInfo)o).id);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean flag=true;
		for(Object o:c)
			flag=flag&&this.remove(o);
		return flag;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		
		return this.internalmap.size();
	}

	@Override
	public Object[] toArray() {
		return this.internalmap.values().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.internalmap.values().toArray(a);
	}
}
