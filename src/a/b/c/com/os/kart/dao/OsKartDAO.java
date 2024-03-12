package a.b.c.com.os.kart.dao;

import java.util.ArrayList;
import java.util.List;

import a.b.c.com.os.kart.vo.OsKartVO;

public interface OsKartDAO {

	public List<OsKartVO> osKartSelectAll(OsKartVO okvo);
	public int osKartDelete(OsKartVO kcvo);
	public int osKartDeleteArray(ArrayList<OsKartVO> aList);
	public int osKartInsert(OsKartVO okvo);
}
