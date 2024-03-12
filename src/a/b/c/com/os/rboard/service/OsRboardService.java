package a.b.c.com.os.rboard.service;

import java.util.List;

import a.b.c.com.os.rboard.vo.OsRboardVO;

public interface OsRboardService {

	public int osRboardInsert(OsRboardVO rbvo);
	public List<OsRboardVO> osRboardSelectAll(OsRboardVO rbvo);
	public int osRboardDelete(OsRboardVO rbvo);
}
