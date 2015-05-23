package com.stevenlothrop.util;

import java.lang.reflect.Field;

public class Struct {
    @Override
    public String toString() {
        Class thisClass = this.getClass();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(thisClass.getSimpleName());
        stringBuilder.append("{");
        Field[] declaredFields = thisClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            stringBuilder.append(field.getName());
            stringBuilder.append("=");
            try {
                Object obj = thisClass.getDeclaredField(field.getName()).get(this);
                if (obj instanceof String) {
                    stringBuilder.append('\'');
                    stringBuilder.append(obj);
                    stringBuilder.append('\'');
                } else {
                    stringBuilder.append(obj);
                }
                if (i < declaredFields.length - 1) {
                    stringBuilder.append(", ");
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }


    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        Class thisClass = this.getClass();

        if (that == null || getClass() != that.getClass()) return false;
        Field[] declaredFields = thisClass.getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                Field declaredField = thisClass.getDeclaredField(field.getName());
                Class<?> type = declaredField.getType();
                if (type == boolean.class) {
                    if (declaredField.getBoolean(this) != declaredField.getBoolean(that)) return false;
                } else if (type == byte.class) {
                    if (declaredField.getByte(this) != declaredField.getByte(that)) return false;
                } else if (type == short.class) {
                    if (declaredField.getShort(this) != declaredField.getShort(that)) return false;
                } else if (type == int.class) {
                    if (declaredField.getInt(this) != declaredField.getInt(that)) return false;
                } else if (type == long.class) {
                    if (declaredField.getLong(this) != declaredField.getLong(that)) return false;
                } else if (type == char.class) {
                    if (declaredField.getChar(this) != declaredField.getChar(that)) return false;
                } else if (type == float.class) {
                    if (Float.compare(declaredField.getFloat(that), declaredField.getFloat(this)) != 0) return false;
                } else if (type == double.class) {
                    if (Double.compare(declaredField.getDouble(that), declaredField.getDouble(this)) != 0) return false;
                } else {
                    if (declaredField.get(this) != null ? !declaredField.get(this).equals(declaredField.get(that)) : declaredField.get(that) != null)
                        return false;
                }
            }
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        Class thisClass = this.getClass();
        Field[] declaredFields = thisClass.getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                Field declaredField = thisClass.getDeclaredField(field.getName());
                Class<?> type = declaredField.getType();
                if (type == boolean.class) {
                    result = 31 * result + (declaredField.getBoolean(this) ? 1 : 0);
                } else if (type == byte.class) {
                    result = 31 * result + (int) declaredField.getByte(this);
                } else if (type == short.class) {
                    result = 31 * result + (int) declaredField.getShort(this);
                } else if (type == int.class) {
                    result = 31 * result + declaredField.getInt(this);
                } else if (type == long.class) {
                    result = 31 * result + (int) (declaredField.getLong(this) ^ (declaredField.getLong(this) >>> 32));
                } else if (type == char.class) {
                    result = 31 * result + (int) declaredField.getChar(this);
                } else if (type == float.class) {
                    result = 31 * result + (declaredField.getFloat(this) != +0.0f ? Float.floatToIntBits(declaredField.getFloat(this)) : 0);
                } else if (type == double.class) {
                    long temp = Double.doubleToLongBits(declaredField.getDouble(this));
                    result = 31 * result + (int) (temp ^ (temp >>> 32));
                } else {
                    result = 31 * result + (declaredField.get(this) != null ? declaredField.get(this).hashCode() : 0);
                }
            }
            return result;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}
