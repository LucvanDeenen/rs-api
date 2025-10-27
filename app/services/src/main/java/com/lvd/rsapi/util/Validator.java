package com.lvd.rsapi.util;

import com.lvd.rsapi.domain.exceptions.InvalidRequestException;

/**
 * Generic validations utility.
 */
public class Validator {

  /**
   * Checks if the value is null or empty.
   *
   * @param value the value to check.
   * @param type  the key of the object.
   */
  public static void checkEmpty(String value, String type) {
    if (value == null || value.isBlank()) {
      throw new InvalidRequestException(String.format("No %s value found.", type));
    }
  }

  /**
   * Parses an enum or returns the default when empty.
   *
   * @param value       target value to convert
   * @param type        the key of the object.
   * @param enumClass   the type of enum.
   * @param defaultEnum the default enum.
   * @return The parsed enum.
   */
  public static <T extends Enum<T>> T parseEnum(String value, String type, Class<T> enumClass,
      T defaultEnum) {
    if (value == null || value.isBlank()) {
      return defaultEnum;
    }

    try {
      return Enum.valueOf(enumClass, value.trim().toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new InvalidRequestException(String.format("Invalid %s passed.", type));
    }
  }

  private Validator() {
  }
}
