package a.b.c.com.os.mem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.os.mem.vo.OsMemVO;

@Repository
public class OsMemDAOImpl implements OsMemDAO {
	Logger logger = LogManager.getLogger(OsMemDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	@Override
	public int osMemInsert(OsMemVO ovo) {
		// TODO Auto-generated method stub
		logger.info("  dao.osMemInsert >>> : ");
		return (Integer)sqlSession.insert("osMemInsert", ovo);
	}

	@Override
	public String OsMemSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String OsMemSelect(OsMemVO ovo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String OsMemUpdate(OsMemVO ovo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OsMemVO> idCheck(OsMemVO ovo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("idCheck", ovo);
	}
	
	@Override
	public List<OsMemVO> loginCheck(OsMemVO ovo){
		return sqlSession.selectList("loginCheck", ovo);
	}
	@Override
	public List<OsMemVO> mypageCheck(OsMemVO ovo) {
		logger.info("osMypageFormdao >>> :");
		return sqlSession.selectList("mypageCheck", ovo);
	}
}
