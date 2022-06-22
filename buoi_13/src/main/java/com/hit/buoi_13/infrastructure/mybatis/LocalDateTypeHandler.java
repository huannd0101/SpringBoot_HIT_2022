package com.hit.buoi_13.infrastructure.mybatis;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@MappedTypes(LocalDate.class)
public class LocalDateTypeHandler implements TypeHandler<Object> {

  public void setParameter(PreparedStatement ps, int i, Object parameter,
                           JdbcType jdbcType) throws SQLException {

    LocalDate date = (LocalDate) parameter;
    if (date != null) {
      ps.setDate(i, Date.valueOf(date));
    } else {
      ps.setDate(i, null);
    }
  }

  public Object getResult(ResultSet rs,
                          String columnName) throws SQLException {
    Date date = rs.getDate(columnName);
    if (date != null) {
      return date.toLocalDate();
    } else {
      return null;
    }
  }

  @Override
  public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
    Date date = rs.getDate(columnIndex);
    if (date != null) {
      return date.toLocalDate();
    } else {
      return null;
    }
  }

  @Override
  public Object getResult(java.sql.CallableStatement cs,
                          int columnIndex) throws SQLException {
    Date date = cs.getDate(columnIndex);
    if (date != null) {
      return date.toLocalDate();
    } else {
      return null;
    }
  }

}
