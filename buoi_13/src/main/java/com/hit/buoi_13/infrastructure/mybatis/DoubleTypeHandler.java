package com.hit.buoi_13.infrastructure.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.DOUBLE)
public class DoubleTypeHandler extends BaseTypeHandler<Double> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, Double parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setDouble(i, parameter);
  }

  @Override
  public Double getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return rs.getDouble(columnName);
  }

  @Override
  public Double getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return rs.getDouble(columnIndex);
  }

  @Override
  public Double getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return cs.getDouble(columnIndex);
  }

}
