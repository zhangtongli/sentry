/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.sentry.provider.db.service.thrift;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum TSentryStoreOp implements org.apache.thrift.TEnum {
  CREATE_ROLE(0),
  DROP_ROLE(1),
  GRANT_PRIVILEGES(2),
  REVOKE_PRVILEGES(3),
  ADD_GROUPS(4),
  DEL_GROUPS(5),
  SET_VERSION(6),
  DROP_PRIVILEGE(7),
  RENAME_PRIVILEGE(8),
  SNAPSHOT(9),
  NO_OP(100);

  private final int value;

  private TSentryStoreOp(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static TSentryStoreOp findByValue(int value) { 
    switch (value) {
      case 0:
        return CREATE_ROLE;
      case 1:
        return DROP_ROLE;
      case 2:
        return GRANT_PRIVILEGES;
      case 3:
        return REVOKE_PRVILEGES;
      case 4:
        return ADD_GROUPS;
      case 5:
        return DEL_GROUPS;
      case 6:
        return SET_VERSION;
      case 7:
        return DROP_PRIVILEGE;
      case 8:
        return RENAME_PRIVILEGE;
      case 9:
        return SNAPSHOT;
      case 100:
        return NO_OP;
      default:
        return null;
    }
  }
}
