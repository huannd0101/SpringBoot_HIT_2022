package com.hit.buoi_13.infrastructure.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.BIGINT)
public class LongTypeHandler extends BaseTypeHandler<Long> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setLong(i, parameter);
  }

  @Override
  public Long getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return rs.getLong(columnName);
  }

  @Override
  public Long getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return rs.getLong(columnIndex);
  }

  @Override
  public Long getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return cs.getLong(columnIndex);
  }
}
