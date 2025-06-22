SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `hotel` DEFAULT CHARACTER SET utf8mb4;

USE `hotel`;

CREATE TABLE `hotel`.`status` (
                          `id` integer AUTO_INCREMENT PRIMARY KEY,
                          `uuid` char(36) UNIQUE,
                          `description` varchar(100),
                          `active` integer,
                          `created_by` varchar(15),
                          `created_at` timestamp,
                          `last_modified_by` varchar(15),
                          `last_modified_at` timestamp
);


CREATE TABLE `hotel`.`room_type` (
                             `id` integer AUTO_INCREMENT PRIMARY KEY,
                             `uuid` char(36) UNIQUE,
                             `description` varchar(100),
                             `active` integer,
                             `created_by` varchar(15),
                             `created_at` timestamp,
                             `last_modified_by` varchar(15),
                             `last_modified_at` timestamp
);


CREATE TABLE `hotel`.`rol` (
                       `id` integer AUTO_INCREMENT PRIMARY KEY,
                       `uuid` char(36) UNIQUE,
                       `code` varchar(50),
                       `description` varchar(100),
                       `active` integer,
                       `created_by` varchar(15),
                       `created_at` timestamp,
                       `last_modified_by` varchar(15),
                       `last_modified_at` timestamp
);


CREATE TABLE `hotel`.`users` (
                         `id` integer AUTO_INCREMENT PRIMARY KEY,
                         `uuid` char(36) UNIQUE,
                         `document_number` varchar(15) UNIQUE,
                         `full_name` varchar(150),
                         `phone` varchar(15),
                         `email` varchar(100),
                         `password` TEXT,
                         `status_id` integer NOT NULL,
                         `active` integer,
                         `created_by` varchar(15),
                         `created_at` timestamp,
                         `last_modified_by` varchar(15),
                         `last_modified_at` timestamp
);

CREATE TABLE `hotel`.`users_role` (
                              `id` integer AUTO_INCREMENT PRIMARY KEY,
                              `uuid` char(36) UNIQUE,
                              `user_id` integer NOT NULL,
                              `rol_id` integer NOT NULL,
                              `active` integer,
                              `created_by` varchar(15),
                              `created_at` timestamp,
                              `last_modified_by` varchar(15),
                              `last_modified_at` timestamp
);


CREATE TABLE `hotel`.`hotel` (
                         `id` integer AUTO_INCREMENT PRIMARY KEY,
                         `uuid` char(36) UNIQUE,
                         `category` int,
                         `address` varchar(150),
                         `location` varchar(100),
                         `status_id` integer NOT NULL,
                         `active` integer,
                         `created_by` varchar(15),
                         `created_at` timestamp,
                         `last_modified_by` varchar(15),
                         `last_modified_at` timestamp
);

CREATE TABLE `hotel`.`hotel_room` (
                              `id` integer AUTO_INCREMENT PRIMARY KEY,
                              `uuid` char(36) UNIQUE,
                              `hotel_id` integer NOT NULL,
                              `room_type_id` integer NOT NULL,
                              `room_number` integer,
                              `capacity` integer,
                              `price_per_hour` decimal(10,2),
                              `price_per_night` decimal(10,2),
                              `is_reserved` integer,
                              `status_id` integer NOT NULL,
                              `active` integer,
                              `created_by` varchar(15),
                              `created_at` timestamp,
                              `last_modified_by` varchar(15),
                              `last_modified_at` timestamp
);

CREATE TABLE `hotel`.`bookings` (
  `id` integer AUTO_INCREMENT PRIMARY KEY,
  `uuid` char(36) UNIQUE,
  `hotel_room_id` int NOT NULL,
  `pin_code` int,
  `check_in` timestamp,
  `total_nights` int,
  `check_out` timestamp,
  `user_id` int null,
  `childrens` int NOT NULL,
  `adults` int NOT NULL,
  `document_number_guest` varchar(200) null,
  `full_name_guest` varchar(200) null,
  `email_guest` varchar(200) null,
  `country_code` char(5) null,
  `phone_number` varchar(20) null,
  `comments` varchar(500),
  `total` decimal(10,2),
  `is_released` int default 0,

    `active` integer,
                              `created_by` varchar(15),
                              `created_at` timestamp,
                              `last_modified_by` varchar(15),
                              `last_modified_at` timestamp
);


CREATE TABLE `hotel`.`bookings_service_type`(
  `id` integer AUTO_INCREMENT PRIMARY KEY,
  `uuid` char(36) UNIQUE,
  `name` varchar(200) null,
  `price` decimal(15,4),
  `active` integer,
                              `created_by` varchar(15),
                              `created_at` timestamp,
                              `last_modified_by` varchar(15),
                              `last_modified_at` timestamp
);

INSERT INTO `hotel`.`bookings_service_type` (`id`, `uuid`, `name`, `price`, `active`, `created_by`, `created_at`)
VALUES
(1, 'd1f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 'Desayuno', 10.00, 1, 'admin', CURRENT_TIMESTAMP),
(2, 'e2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 'Almuerzo', 15.00, 1, 'admin', CURRENT_TIMESTAMP),
(3, 'f3f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 'Cena', 20.00, 1, 'admin', CURRENT_TIMESTAMP),
(4, 'g4f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 'Servicio de limpieza', 5.00, 1, 'admin', CURRENT_TIMESTAMP),
(5, 'h5f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 'Transporte al aeropuerto', 30.00, 1, 'admin', CURRENT_TIMESTAMP);

CREATE TABLE `hotel`.`bookings_service`(
  `id` integer AUTO_INCREMENT PRIMARY KEY,
  `uuid` char(36) UNIQUE,
   `booking_id` int not null,
   `bookings_service_type_id` int not null,
   `count` int not null,
   `price` decimal(15,4),
   `price_total` decimal(15,4),
    `active` integer,
                              `created_by` varchar(15),
                              `created_at` timestamp,
                              `last_modified_by` varchar(15),
                              `last_modified_at` timestamp
);

ALTER TABLE `hotel`.`bookings_service` ADD CONSTRAINT `fk_bookings_service_booking_id` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`);
ALTER TABLE `hotel`.`bookings_service` ADD CONSTRAINT `fk_bookings_service_bookings_service_type_id` FOREIGN KEY (`booking_id`) REFERENCES `bookings_service_type` (`id`);



CREATE TABLE `hotel`.`invoice` (
 `id` integer AUTO_INCREMENT PRIMARY KEY,
  `uuid` char(36) UNIQUE,
   `document_invoice` varchar(200),
  `booking_id` int not null,
    `amount_total` decimal(15,4),
    `active` integer,
                              `created_by` varchar(15),
                              `created_at` timestamp,
                              `last_modified_by` varchar(15),
                              `last_modified_at` timestamp

);

ALTER TABLE `hotel`.`invoice` ADD CONSTRAINT `fk_invoice_booking_id` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`);

CREATE TABLE `hotel`.`invoice_detail` (
 `id` integer AUTO_INCREMENT PRIMARY KEY,
  `uuid` char(36) UNIQUE,
    `invoice_id` int not null,
   `description` varchar(200),
  `unit` int not null,
    `amount_total` decimal(15,4),
    `active` integer,
                              `created_by` varchar(15),
                              `created_at` timestamp,
                              `last_modified_by` varchar(15),
                              `last_modified_at` timestamp

);

ALTER TABLE `hotel`.`invoice_detail` ADD CONSTRAINT `fk_invoice_detail_invoice_id` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`);



ALTER TABLE `hotel`.`bookings` ADD CONSTRAINT `fk_bookings_hotel_room_id` FOREIGN KEY (`hotel_room_id`) REFERENCES `hotel_room` (`id`);

ALTER TABLE `hotel`.`users` ADD CONSTRAINT `user_posts` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

ALTER TABLE `hotel`.`users_role` ADD CONSTRAINT `user_roles_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `hotel`.`users_role` ADD CONSTRAINT `user_roles_rol` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);

ALTER TABLE `hotel`.`hotel` ADD FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

ALTER TABLE `hotel`.`hotel_room` ADD FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

ALTER TABLE `hotel`.`hotel_room` ADD FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`);

ALTER TABLE `hotel`.`hotel_room` ADD FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`id`);


INSERT  INTO `hotel`.`status` (`id`, `uuid`, `description`, `active`, `created_by`, `created_at`)
VALUES (1, '55a744e6-49f5-4b24-9bb8-96379274cdbd', 'Activo', 1, 'admin', CURRENT_TIMESTAMP),
       (2, '77d2623c-8bb0-418a-bc09-5c277f80aa93', 'Inactivo', 0, 'admin', CURRENT_TIMESTAMP);

INSERT  INTO `hotel`.`room_type` (`id`, `uuid`, `description`, `active`, `created_by`, `created_at`)
VALUES (1, 'cc96e3cb-ebf6-4fa7-8496-47764590679c', 'Habitación individual', 1, 'admin', CURRENT_TIMESTAMP),
       (2, 'f02be042-95f5-4ce3-b7cd-efa0406e2545', 'Habitación doble estándar (una cama doble)', 1, 'admin', CURRENT_TIMESTAMP),
       (3, '26f2bf93-5f23-4380-a96e-b680fae07ba4', 'Habitación doble estándar (dos camas separadas)', 1, 'admin', CURRENT_TIMESTAMP),
       (4, '00d78805-b95b-4e9d-92ef-908d58e9fa9b', 'Habitación doble deluxe', 1, 'admin', CURRENT_TIMESTAMP),
       (5, '183b580d-2eea-4422-9a00-e4fe0d675185', 'Suite júnior', 1, 'admin', CURRENT_TIMESTAMP),
       (6, '90aef3b6-9915-40c4-b69b-be5c9e380145', 'Suite ejecutiva', 1, 'admin', CURRENT_TIMESTAMP),
       (7, '7c03ee78-b6d9-4c06-8c81-bba5e6cd14a0', 'Suite presidencial', 1, 'admin', CURRENT_TIMESTAMP);



INSERT  INTO `hotel`.`rol` (`id`, `uuid`,`code`, `description`, `active`, `created_by`, `created_at`)
VALUES (1, '6bb31ba7-7ee3-41ca-be1f-662baad66c49','ROOT', 'Super Administrador', 1, 'admin', CURRENT_TIMESTAMP),
       (2, '55354268-ccb2-466c-9e91-6e9a4709d6d5','ADMIN', 'Administrador', 1, 'admin', CURRENT_TIMESTAMP),
       (3, 'e1b7ecb0-0854-4dd0-9482-8cce27757e23','RECEPCIONISTA', 'Recepcionista', 1, 'admin', CURRENT_TIMESTAMP),
       (4, '6783f6b7-27c2-4fee-b0b9-58a38973b271', 'CLIENT','Cliente', 1, 'admin', CURRENT_TIMESTAMP);



INSERT  INTO `hotel`.`users` (`id`, `uuid`, `document_number`, `full_name`, `phone`, `email`, `password`, `status_id`, `active`, `created_by`, `created_at`)
VALUES (1,'b0f3a3d4-5c8e-4b7c-9f6d-5a2e0f3b8c1e','admin','Super Administrador','99999999','99999999@gmail.com','$2a$12$Fi3f.vLMBKM0YsUzy8npU.KQzFsqUogsl.y6eoYUP68YTTkm/wGE.',1,1,'ADMIN',CURRENT_TIMESTAMP),
(2,'995b2f58-3185-4b1f-b389-7ea4515a203a','72854591','Bryan Vislao Chavez','99999999','99999999@gmail.com','$2a$12$Fi3f.vLMBKM0YsUzy8npU.KQzFsqUogsl.y6eoYUP68YTTkm/wGE.',1,1,'ADMIN',CURRENT_TIMESTAMP);


INSERT  INTO `hotel`.`users_role` (`id`, `uuid`, `user_id`, `rol_id`, `active`, `created_by`, `created_at`)
VALUES (1, 'b0f2a3d4-5c8e-4b7c-9f6d-5a2e0f3b8c1e', 1, 1, 1, 'admin', CURRENT_TIMESTAMP),
 (2, '6c8faba2-1935-458e-ac8c-53557f89e50d', 2, 3, 1, 'admin', CURRENT_TIMESTAMP);


INSERT  INTO `hotel`.`hotel` (`id`, `uuid`, `category`, `address`, `location`, `status_id`, `active`, `created_by`, `created_at`)
VALUES (1, 'a2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 5, 'Lima Centro', '-12.066188148973394, -77.03696239441621', 1, 1, 'admin', CURRENT_TIMESTAMP);


INSERT  INTO `hotel`.`hotel_room` (`id`, `uuid`, `hotel_id`, `room_type_id`, `room_number`, `price_per_hour`, `price_per_night`, `is_reserved`,`capacity`, `status_id`, `active`, `created_by`, `created_at`)
VALUES (1, 'a2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 1, 101, 50.00, 200.00, 0, 2,1, 1, 'admin', CURRENT_TIMESTAMP),
       (2, 'b2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 2, 102, 75.00, 300.00, 0, 2,1, 1, 'admin', CURRENT_TIMESTAMP),
       (3, 'c2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 1, 103, 60.00, 220.00, 0, 2, 1, 1, 'admin', CURRENT_TIMESTAMP),
(4, 'd2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 2, 104, 80.00, 320.00, 0, 3, 1, 1, 'admin', CURRENT_TIMESTAMP),
(5, 'e2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 1, 105, 55.00, 210.00, 0, 2, 1, 1, 'admin', CURRENT_TIMESTAMP),
(6, 'f2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 3, 106, 100.00, 400.00, 0, 4, 1, 1, 'admin', CURRENT_TIMESTAMP),
(7, 'g2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 2, 107, 70.00, 290.00, 0, 3, 1, 1, 'admin', CURRENT_TIMESTAMP),
(8, 'h2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 1, 108, 50.00, 200.00, 0, 2, 1, 1, 'admin', CURRENT_TIMESTAMP),
(9, 'i2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 3, 109, 110.00, 420.00, 0, 4, 1, 1, 'admin', CURRENT_TIMESTAMP),
(10,'j2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 2, 110, 85.00, 350.00, 0, 3, 1, 1, 'admin', CURRENT_TIMESTAMP);



/******************************************************************************************
*
* Descripción        :    Función que retorna codigo de la factura o boleta
* Autor              :    Bryan Vislao
* Fecha de creación  :    2025-06-18
* Base de datos      :    hotel
* Entorno            :    Dev
* Versión            :    1.0
*
* Historial de cambios:
* ----------------------------------------------------------------------------------------
* Fecha       | Autor            | Descripción
* ------------|------------------|-------------------------------------------------------
* 2025-06-18  | Bryan Vislao | Versión inicial
*
******************************************************************************************/

DELIMITER $$

CREATE FUNCTION generate_invoice_name(booking_id INT)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(50);
    
    SET result = CONCAT(
        'INV_',
        DATE_FORMAT(NOW(), '%Y_%m_%d_'),
        booking_id,
        '_',
        DATE_FORMAT(NOW(), '%H%i%s')
    );

    RETURN result;
END$$

DELIMITER ;


/******************************************************************************************
*
* Descripción        :    Función que retorna codigo UUID
* Autor              :    Bryan Vislao
* Fecha de creación  :    2025-06-18
* Base de datos      :    hotel
* Entorno            :    Dev
* Versión            :    1.0
*
* Historial de cambios:
* ----------------------------------------------------------------------------------------
* Fecha       | Autor            | Descripción
* ------------|------------------|-------------------------------------------------------
* 2025-06-18  | Bryan Vislao | Versión inicial
*
******************************************************************************************/


CREATE FUNCTION uuid_v4()
RETURNS CHAR(36)
DETERMINISTIC
BEGIN
  RETURN LOWER(CONCAT(
    LPAD(HEX(FLOOR(RAND() * 0xffffffff)), 8, '0'), '-',
    LPAD(HEX(FLOOR(RAND() * 0xffff)), 4, '0'), '-',
    '4', LPAD(HEX(FLOOR(RAND() * 0x0fff)), 3, '0'), '-', -- versión 4
    SUBSTRING('89ab', FLOOR(1 + (RAND() * 4)), 1), LPAD(HEX(FLOOR(RAND() * 0x0fff)), 3, '0'), '-', -- variante
    LPAD(HEX(FLOOR(RAND() * 0xffff)), 4, '0'),
    LPAD(HEX(FLOOR(RAND() * 0xffff)), 4, '0'),
    LPAD(HEX(FLOOR(RAND() * 0xffff)), 4, '0')
  ));
END;


DELIMITER $$

CREATE PROCEDURE spBookingCreated(
    IN p_uuid CHAR(36),
    IN p_hotel_room_id INT,
    IN p_pin_code INT,
    IN p_check_in DATE,
    IN p_user_id INT,
    IN p_childrens INT,
    IN p_adults INT,
    IN p_document_number_guest VARCHAR(200),
    IN p_full_name_guest VARCHAR(200),
    IN p_email_guest VARCHAR(200),
    IN p_country_code CHAR(5),
    IN p_phone_number VARCHAR(20),
    IN p_comments VARCHAR(500),
    IN p_active INT,
    IN p_created_by VARCHAR(15),
    IN p_created_at DATETIME,
    IN p_total_nights INT,
    IN p_total DECIMAL(10, 2)
)
BEGIN
    INSERT INTO bookings (
        uuid, hotel_room_id, pin_code, check_in, user_id, childrens, adults,
        document_number_guest, full_name_guest, email_guest, country_code, phone_number,
        comments, active, created_by, created_at, total_nights, total
    )
    VALUES (
        p_uuid, p_hotel_room_id, p_pin_code, p_check_in, p_user_id, p_childrens, p_adults,
        p_document_number_guest, p_full_name_guest, p_email_guest, p_country_code, p_phone_number,
        p_comments, p_active, p_created_by, p_created_at, p_total_nights, p_total
    );
    -- ACTUALIZO EL CUARTO COMO RESERVADO
    UPDATE hotel_room
    SET is_reserved = 1
    WHERE id = p_hotel_room_id;

END$$

DELIMITER ;




DELIMITER $$

CREATE PROCEDURE spInsertUser(
    IN p_role_id INT,
    IN p_uuid CHAR(36),
    IN p_document_number VARCHAR(50),
    IN p_full_name VARCHAR(200),
    IN p_phone VARCHAR(20),
    IN p_email VARCHAR(200),
    IN p_password VARCHAR(255),
    IN p_status_id INT,
    IN p_active INT,
    IN p_created_by VARCHAR(15),
    IN p_created_at DATETIME
)
BEGIN
    -- Insertar en tabla de usuarios
    INSERT INTO hotel.users (
        uuid, document_number, full_name, phone, email, password,
        status_id, active, created_by, created_at
    )
    VALUES (
        p_uuid, p_document_number, p_full_name, p_phone, p_email, p_password,
        p_status_id, p_active, p_created_by, p_created_at
    );

    -- Obtener el ID del usuario recién insertado
    SET @last_id = LAST_INSERT_ID();

    -- Insertar en tabla users_role
    INSERT INTO hotel.users_role (
        uuid, user_id, rol_id, active, created_by, created_at
    )
    VALUES (
        uuid_v4(), @last_id, p_role_id, p_active, p_created_by, p_created_at
    );
END$$

DELIMITER ;




DELIMITER $$

CREATE PROCEDURE spListRooms()
BEGIN
    select hr.id,hr.uuid,hr.hotel_id,b.id as booking_id,
       hr.room_type_id,hr.room_number,hr.capacity,hr.price_per_hour,hr.price_per_night,hr.is_reserved,hr.status_id
from hotel_room hr
left join hotel.bookings b on hr.id = b.hotel_room_id and b.is_released = 0
where hr.hotel_id = 1 and hr.status_id = 1;
END$$
DELIMITER ;


/******************************************************************************************
*
* Descripción        :    Lista los servicios asociados a una reserva específica.
* Autor              :    Bryan Vislao
* Fecha de creación  :    2025-06-18
* Base de datos      :    hotel
* Entorno            :    Dev
* Versión            :    1.0
*
* Historial de cambios:
* ----------------------------------------------------------------------------------------
* Fecha       | Autor            | Descripción
* ------------|------------------|-------------------------------------------------------
* 2025-06-18  | Bryan Vislao | Versión inicial
*
******************************************************************************************/

DELIMITER $$

CREATE PROCEDURE spListServicesByBooking(
    IN p_booking_id INT
    )
BEGIN
    SELECT  bs.id,bs.uuid,bst.name,bs.count,bs.price,bs.price_total FROM bookings_service bs
             INNER JOIN bookings_service_type bst on bs.bookings_service_type_id = bst.id
             WHERE bs.booking_id = p_booking_id and bs.active=1;
END$$

DELIMITER ;



/******************************************************************************************
*
* Descripción        :    Busca las reservas de una persona que esten pendientes de hacer check-out.
* Autor              :    Bryan Vislao
* Fecha de creación  :    2025-06-18
* Base de datos      :    hotel
* Entorno            :    Dev
* Versión            :    1.0
*
* Historial de cambios:
* ----------------------------------------------------------------------------------------
* Fecha       | Autor            | Descripción
* ------------|------------------|-------------------------------------------------------
* 2025-06-18  | Bryan Vislao | Versión inicial
*
******************************************************************************************/

DELIMITER $$

CREATE PROCEDURE spSearchBookingForCheckOut(
    IN document_number VARCHAR(15)
    )
BEGIN
    SELECT
        bk.id,
        bk.uuid,
        CONCAT(CAST(hr.room_number AS CHAR),"-",UPPER(rt.description)) AS room_number,
        hr.uuid AS room_uuid,
        bk.total as sub_total,
        IFNULL(bks.total_services, 0) AS sub_total_services,
        (bk.total + IFNULL(bks.total_services, 0)) AS total
    FROM bookings bk
             INNER JOIN hotel_room hr ON hr.id = bk.hotel_room_id
             INNER JOIN room_type rt on hr.room_type_id = rt.id
             LEFT JOIN (SELECT booking_id,SUM(price_total) AS total_services  FROM bookings_service
                        GROUP BY booking_id) bks on bks.booking_id = bk.id

    WHERE document_number_guest = document_number and bk.is_released = 0 and bk.check_out IS NULL;
END$$

DELIMITER ;



/******************************************************************************************
*
* Descripción        :    Checkout de la reserva y genera invoice con el detalle
* Autor              :    Bryan Vislao
* Fecha de creación  :    2025-06-18
* Base de datos      :    hotel
* Entorno            :    Dev
* Versión            :    1.0
*
* Historial de cambios:
* ----------------------------------------------------------------------------------------
* Fecha       | Autor            | Descripción
* ------------|------------------|-------------------------------------------------------
* 2025-06-18  | Bryan Vislao | Versión inicial
*
******************************************************************************************/

DELIMITER $$

CREATE PROCEDURE spCheckoutBooking(
    IN p_booking_uuid CHAR(36),
    IN p_user_name VARCHAR(50)
    )
BEGIN
    -- LIBERO LA RESERVA
   UPDATE bookings
    SET is_released = 1,
         check_out = NOW()
    WHERE uuid = p_booking_uuid;

    -- SELECCIONO LA HABITACION
   SELECT @room_id := bookings.hotel_room_id,@booking_id := id
          from bookings WHERE uuid= p_booking_uuid;

    SELECT @total_amount := bk.total + IFNULL(bks.total_services,0) FROM bookings bk
     LEFT JOIN (SELECT booking_id,SUM(price_total) AS total_services  FROM bookings_service
                        GROUP BY booking_id) bks on bks.booking_id = bk.id
    WHERE bk.id = @booking_id;


    -- LIBERO LA HABITACIÓN
   UPDATE hotel_room
   SET is_reserved = 0
   WHERE id = @room_id;

    INSERT INTO invoice (uuid, document_invoice, booking_id, amount_total, active, created_by, created_at)
    VALUES (uuid_v4(), generate_invoice_name(@booking_id), @booking_id, @total_amount, 1, p_user_name, NOW());
    -- GENERO LA FACTURA
    SET @invoice_id = LAST_INSERT_ID();

    -- INSERTO EL DETALLE DE LA FACTURA
    INSERT INTO invoice_detail (uuid, invoice_id, description, unit, amount_total, active, created_by, created_at)
    SELECT uuid_v4(), @invoice_id,'HABITACION POR NOCHE', total_nights, total, 1, p_user_name, NOW()
    FROM bookings WHERE id= @booking_id;

    INSERT INTO invoice_detail (uuid, invoice_id, description, unit, amount_total, active, created_by, created_at)
    SELECT uuid_v4(), @invoice_id, bookings_service_type.name, bookings_service.count, bookings_service.price, 1, p_user_name, NOW()
    FROM bookings_service
    INNER JOIN bookings_service_type ON bookings_service.bookings_service_type_id = bookings_service_type.id
    WHERE booking_id = @booking_id;

END$$

DELIMITER ;



/******************************************************************************************
*
* Descripción        :    Lista las facturas creadas
* Autor              :    Bryan Vislao
* Fecha de creación  :    2025-06-21
* Base de datos      :    hotel
* Entorno            :    Dev
* Versión            :    1.0
*
* Historial de cambios:
* ----------------------------------------------------------------------------------------
* Fecha       | Autor            | Descripción
* ------------|------------------|-------------------------------------------------------
* 2025-06-18  | Bryan Vislao | Versión inicial
*
******************************************************************************************/

DELIMITER $$

CREATE PROCEDURE spListInvoices()
BEGIN
    SELECT uuid,document_invoice,booking_id,amount_total,created_by FROM invoice WHERE active = 1;
END$$

DELIMITER ;