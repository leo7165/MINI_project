package a.b.c.com.os.rboard.dao;

import java.util.List;

import a.b.c.com.os.rboard.vo.OsRboardVO;

public interface OsRboardDAO {
	
	public int osRboardInsert(OsRboardVO rbvo);
	public List<OsRboardVO> osRboardSelectAll(OsRboardVO rbvo);
	public int osRboardDelete(OsRboardVO rbvo);

}
