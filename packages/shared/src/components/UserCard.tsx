import React from "react";

export const UserCard = ({
  username,
  password,
}: {
  username?: string;
  password?: string;
}) => {
  return (
    <div style={{ border: "1px solid green", padding: 20 }}>
      <div> username: {username ?? "user"}</div>
      <div>password: {password ?? "***"}</div>
    </div>
  );
};
