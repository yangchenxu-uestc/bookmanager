package com.example.bookmanager.mapper;

import com.example.bookmanager.entity.BorrowingBooks;
import com.example.bookmanager.entity.BorrowingBooksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowingBooksMapper {
    long countByExample(BorrowingBooksExample example);

    int deleteByExample(BorrowingBooksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BorrowingBooks record);

    int insertSelective(BorrowingBooks record);

    List<BorrowingBooks> selectByExample(BorrowingBooksExample example);

    BorrowingBooks selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BorrowingBooks record, @Param("example") BorrowingBooksExample example);

    int updateByExample(@Param("record") BorrowingBooks record, @Param("example") BorrowingBooksExample example);

    int updateByPrimaryKeySelective(BorrowingBooks record);

    int updateByPrimaryKey(BorrowingBooks record);
}