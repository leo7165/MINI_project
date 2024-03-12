package a.b.c.com.os.lecture.dao;

import java.util.List;

import a.b.c.com.os.lecture.vo.OsLectureVO;

public interface OsLectureDAO {
	public List<OsLectureVO> osLectureSelectAll(OsLectureVO ovo);
	public List<OsLectureVO> osLectureSelectOne(OsLectureVO ovo);
	public List osLectureSelectMain(OsLectureVO ovo);
	public List osLectureSelect(OsLectureVO ovo);
}
