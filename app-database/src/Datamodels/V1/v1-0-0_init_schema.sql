-- liquibase formatted sql

-- changeset hungnguyen:V1.0.0-init-shema
-- tagDatabase V1.0.0

CREATE TABLE sec_user (
    user_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    keycloak_id VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    full_name VARCHAR(255),
    created_at DATETIME2 DEFAULT SYSDATETIME()
);


CREATE TABLE role (
    role_id BIGINT IDENTITY(1,1) PRIMARY KEY,
    role VARCHAR(50) NOT NULL UNIQUE
);



CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES sec_user(user_id),
    CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES role(role_id)
);

--rollback drop table user_roles;
--rollback drop table sec_user;
--rollback drop table role;


