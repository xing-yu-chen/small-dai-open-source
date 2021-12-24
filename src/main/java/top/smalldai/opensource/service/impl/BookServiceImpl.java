package top.smalldai.opensource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.smalldai.opensource.entity.Book;
import top.smalldai.opensource.mapper.BookMapper;
import top.smalldai.opensource.service.BookService;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 书本ServiceImpl
* @Data:Created in 2021/12/21 9:58 下午
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper,Book> implements BookService {
}
