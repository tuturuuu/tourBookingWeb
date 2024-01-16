create table asm1.User (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	user_name varchar(25) DEFAULT NULL,
	password varchar(25)  DEFAULT NULL,
	phone_num varchar(20)  DEFAULT NULL,	
    address varchar(100)  NOT NULL,
    full_name varchar(25) DEFAULT NULL,
    role varchar(10) NOT NULL,
    email varchar(30) NOT NULL,
    status boolean NOT NULL,
    PRIMARY KEY (`id`)
);
	
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
    
    
DROP table asm1.User;

insert into asm1.User values (1,'tuturuu', 'admin', '0911111111', 'Ha Noi', 'Pham Minh Viet', 'admin','vietpm@', true);

select * from asm1.User;

SELECT * FROM  asm1.User WHERE email = vietpm OR phone_num = 0911111111;

SET SQL_SAFE_UPDATES = 0;

delete from asm1.User where role = 'user';

DELETE FROM asm1.User WHERE id = 5

SET SQL_SAFE_UPDATES = 1;

ALTER DATABASE asm1 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE asm1.User CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
