package a.b.c.com.os.mem.service;

import java.util.List;

import a.b.c.com.os.mem.vo.OsMemVO;

public interface OsMemService {
	public int osMemInsert(OsMemVO ovo);
	public String OsMemSelectAll();
	public String OsMemSelect(OsMemVO ovo);
	public String OsMemUpdate(OsMemVO ovo);
	public List<OsMemVO> idCheck(OsMemVO ovo);
	public List<OsMemVO> loginCheck(OsMemVO ovo);
	public List<OsMemVO> mypageCheck(OsMemVO ovo);
}
