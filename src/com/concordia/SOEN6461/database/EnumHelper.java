//The MIT License (MIT)
//
//Copyright (c) 2014 - Mathieu Nayrolles
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in
//all copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//THE SOFTWARE.

package com.concordia.SOEN6461.database;

/**
 * @author Mathieu Nayrolles
 */
import java.io.Serializable;   
import java.sql.PreparedStatement;   
import java.sql.ResultSet;   
import java.sql.SQLException;   
import java.sql.Types;   
import org.hibernate.HibernateException;   
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;   
  
public class EnumHelper<E extends Enum<E>> implements UserType {   
    private Class<E> clazz = null;   
   
    protected EnumHelper(Class<E> c) {   
        this.clazz = c;   
    }   
   
    private static final int[] SQL_TYPES = {Types.VARCHAR};   
    public int[] sqlTypes() {   
        return SQL_TYPES;   
    }   
   
    public Class returnedClass() {   
        return clazz;   
    }   
   
    public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner) throws HibernateException, SQLException {   
        String name = resultSet.getString(names[0]);   
        E result = null;   
        if (!resultSet.wasNull()) {   
            result = Enum.valueOf(clazz, name);   
        }   
        return result;   
    }   
   
    public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index) throws HibernateException, SQLException {   
        if (null == value) {   
            preparedStatement.setNull(index, Types.VARCHAR);   
        } else {   
            preparedStatement.setString(index, ((Enum)value).name());   
        }   
    }

    /**
     *
     * @param value
     * @return
     * @throws HibernateException
     */
    @Override
    public Object deepCopy(Object value) throws HibernateException{   
        return value;   
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isMutable() {   
        return false;   
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
         return cached;  
    }

    /**
     *
     * @param value
     * @return
     * @throws HibernateException
     */
    @Override
    public Serializable disassemble(Object value) throws HibernateException {   
        return (Serializable)value;   
    }   
   
    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {   
        return original;   
    }   

    /**
     *
     * @param x
     * @return
     * @throws HibernateException
     */
    @Override
    public int hashCode(Object x) throws HibernateException {   
        return x.hashCode();   
    }   

    /**
     *
     * @param x
     * @param y
     * @return
     * @throws HibernateException
     */
    @Override
    public boolean equals(Object x, Object y) throws HibernateException {   
        if (x == y)   
            return true;   
        if (null == x || null == y)   
            return false;   
        return x.equals(y);   
    }   

    @Override
    public Object nullSafeGet(ResultSet rs, String[] strings, SessionImplementor si, Object o) throws HibernateException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nullSafeSet(PreparedStatement ps, Object o, int i, SessionImplementor si) throws HibernateException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}   