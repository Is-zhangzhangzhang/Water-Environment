package com.scau.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scau.pojo.File;
import com.scau.pojo.FileExample;

@Repository
public interface FileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    int countByExample(FileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    int deleteByExample(FileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    @Delete({
        "delete from file",
        "where file_id = #{fileId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer fileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    @Insert({
        "insert into file (file_id, file_name, ",
        "file_type, file_discribe, ",
        "file_directory, file_complete_path, ",
        "file_relative_path, file_author)",
        "values (#{fileId,jdbcType=INTEGER}, #{fileName,jdbcType=VARCHAR}, ",
        "#{fileType,jdbcType=VARCHAR}, #{fileDiscribe,jdbcType=VARCHAR}, ",
        "#{fileDirectory,jdbcType=VARCHAR}, #{fileCompletePath,jdbcType=VARCHAR}, ",
        "#{fileRelativePath,jdbcType=VARCHAR}, #{fileAuthor,jdbcType=VARCHAR})"
    })
    int insert(File record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    int insertSelective(File record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    List<File> selectByExample(FileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "file_id, file_name, file_type, file_discribe, file_directory, file_complete_path, ",
        "file_relative_path, file_author",
        "from file",
        "where file_id = #{fileId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    File selectByPrimaryKey(Integer fileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(File record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file
     *
     * @mbggenerated
     */
    @Update({
        "update file",
        "set file_name = #{fileName,jdbcType=VARCHAR},",
          "file_type = #{fileType,jdbcType=VARCHAR},",
          "file_discribe = #{fileDiscribe,jdbcType=VARCHAR},",
          "file_directory = #{fileDirectory,jdbcType=VARCHAR},",
          "file_complete_path = #{fileCompletePath,jdbcType=VARCHAR},",
          "file_relative_path = #{fileRelativePath,jdbcType=VARCHAR},",
          "file_author = #{fileAuthor,jdbcType=VARCHAR}",
        "where file_id = #{fileId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(File record);
}