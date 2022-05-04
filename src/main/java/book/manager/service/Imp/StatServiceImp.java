package book.manager.service.Imp;

import book.manager.entity.GlobalStat;
import book.manager.mapper.BookMapper;
import book.manager.mapper.UserMapper;
import book.manager.service.StatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StatServiceImp implements StatService {

    @Resource
    UserMapper userMapper;

    @Resource
    BookMapper bookMapper;

    @Override
    public GlobalStat getGlobalStat() {
        return new GlobalStat(userMapper.getStudentCount(), bookMapper.getBookCount(), bookMapper.getBorrowCount());
    }
}
