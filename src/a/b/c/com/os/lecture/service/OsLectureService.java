package a.b.c.com.os.lecture.service;

import java.util.List;

import a.b.c.com.os.lecture.vo.OsLectureVO;

public interface OsLectureService {
	public List<OsLectureVO> osLectureSelectAll(OsLectureVO ovo);
	public List<OsLectureVO> osLectureSelectOne(OsLectureVO ovo);
	public List osLectureSelectMain(OsLectureVO ovo);
	public List osLectureSelect(OsLectureVO ovo);
}
