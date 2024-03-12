package a.b.c.com.os.lecture.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.os.lecture.dao.OsLectureDAO;
import a.b.c.com.os.lecture.dao.OsLectureDAOImpl;
import a.b.c.com.os.lecture.vo.OsLectureVO;

@Service
@Transactional
public class OsLectureServiceImpl implements OsLectureService {
	Logger logger = LogManager.getLogger(OsLectureDAOImpl.class);
	
	@Autowired
	private OsLectureDAO osLectureDAO;
	
	@Override
	public List<OsLectureVO> osLectureSelectAll(OsLectureVO ovo){
		logger.info("osLectureSelectAll 서비스 진입>>> : " );
		return osLectureDAO.osLectureSelectAll(ovo);
	}
	
	@Override
	public List<OsLectureVO> osLectureSelectOne(OsLectureVO ovo){
		logger.info("osLectureSelectOne 서비스 진입>>> : ");
		return osLectureDAO.osLectureSelectOne(ovo);
	}
	
	@Override
	public List osLectureSelectMain(OsLectureVO ovo) {
		// TODO Auto-generated method stub
		logger.info("osLectureSelectMain 함수 진입 >>> : ");
		
		return osLectureDAO.osLectureSelectMain(ovo);
	}
	
	@Override
	public List osLectureSelect(OsLectureVO ovo) {
		// TODO Auto-generated method stub
		logger.info("osLectureService 함수 진입 >>> : ");
		
		return osLectureDAO.osLectureSelect(ovo);
	}

}
