-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-08-2019 a las 20:18:45
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `amazonviewer`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `author`
--

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 NOT NULL,
  `book_id` int(11) NOT NULL,
  `magazine_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `author`
--

INSERT INTO `author` (`author_id`, `author`, `book_id`, `magazine_id`) VALUES
(1, 'Gabriel García Márquez', 1, 1),
(2, 'Fedor Dostoievski', 2, 1),
(3, 'Robert A. Heinlein', 3, 1),
(4, 'Gabrielito', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 NOT NULL,
  `editiondate` datetime NOT NULL,
  `editorial` varchar(255) CHARACTER SET utf8 NOT NULL,
  `isbn` varchar(255) CHARACTER SET utf8 NOT NULL,
  `read` tinyint(1) NOT NULL,
  `timeread` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `book`
--

INSERT INTO `book` (`id`, `title`, `editiondate`, `editorial`, `isbn`, `read`, `timeread`) VALUES
(1, '100 años de Soledad', '2019-08-06 09:04:00', 'Sudamericana ', '9500700298', 0, 0),
(2, 'Crimen y castigo', '2019-08-06 07:07:27', 'Porrua', '8437624908', 0, 0),
(3, 'La Luna Es Una Cruel Amante', '2019-08-16 15:13:30', 'Circulo de Lectores', '842260812X', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chapter`
--

CREATE TABLE `chapter` (
  `chapter_id` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 NOT NULL,
  `genre` varchar(255) CHARACTER SET utf8 NOT NULL,
  `creator` varchar(255) NOT NULL,
  `duration` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `seasonumber` int(11) NOT NULL,
  `series` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `magazine`
--

CREATE TABLE `magazine` (
  `magazine_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `editiondate` datetime NOT NULL,
  `editorial` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `magazine`
--

INSERT INTO `magazine` (`magazine_id`, `title`, `editiondate`, `editorial`) VALUES
(2, 'Televisa', '2019-08-06 07:07:27', 'Televisa'),
(3, 'Proceso', '2019-07-08 15:13:30', 'Comunicación e Información, S.A de C.V.'),
(4, 'The New York Time', '2019-08-31 14:12:47', 'USA, LLC.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`id`, `name`) VALUES
(1, 'movie'),
(2, 'serie'),
(3, 'chapter'),
(4, 'book'),
(5, 'magazine');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `creator` varchar(255) NOT NULL,
  `duration` int(11) NOT NULL,
  `year` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `movie`
--

INSERT INTO `movie` (`id`, `title`, `genre`, `creator`, `duration`, `year`) VALUES
(6, 'Coco', 'Animación', 'Pixart', 120, 2017),
(7, 'Titanic', 'Drama', 'James Cameron', 195, 1997),
(8, 'Avatar', 'Ficción', 'James Cameron', 161, 2009),
(9, 'Amélie', 'Romance', 'Jean-Pierre Jeunet', 123, 2001),
(10, 'Sombra del Agua', 'Drama-Fantasía', 'Guillermo del Toro', 123, 2017);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `page`
--

CREATE TABLE `page` (
  `page_id` int(11) NOT NULL,
  `page` varchar(255) CHARACTER SET utf8 NOT NULL,
  `book_id` int(11) NOT NULL,
  `page_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `page`
--

INSERT INTO `page` (`page_id`, `page`, `book_id`, `page_number`) VALUES
(1, 'Muchos años después, frente al pelotón de fusilamiento, el coronel Aureliano Buendía había de recordar aquella tarde remota en que su padre lo llevó a conocer el hielo. ', 1, 1),
(2, 'En una tarde extremadamente calurosa de principios de julio, un joven salió de la reducida habitación que tenía alquilada en la callejuela de S*** y, con paso lento e indeciso, se dirigió al puente K***.', 2, 1),
(3, 'Veo en el Lunaya Pravda que el Consejo de Luna City ha pasado en primera lectura un proyecto de ley para inspeccionar, autorizar - y cargar de impuestos - a los vendedores de alimentos que operen dentro de la presión municipal. ', 3, 1),
(4, 'Macondo era entonces una aldea de 20 casas de barro y cañabrava construidas a la orilla de un río de aguas diáfanas que se precipitaban por un lecho de piedras pulidas, blancas y enormes como huevos prehistóricos. ', 1, 2),
(5, 'El mundo era tan reciente, que muchas cosas carecían de nombre, y para mencionarlas había que señalarlas con el dedo.\r\n', 1, 3),
(6, 'Había tenido la suerte de no encontrarse con su patrona en la escalera.', 2, 2),
(7, 'Su cuartucho se hallaba bajo el tejado de un gran edificio de cinco pisos y, más que una habitación, parecía una alacena. ', 2, 3),
(8, 'Veo también que esta noche se celebrará una reunión de masas para organizar unas charlas sobre «Los Hijos de la Revolución».', 3, 2),
(9, 'Mi viejo me enseñó dos cosas: «Ocúpate de tus propios asuntos», y «Corta siempre la baraja».', 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `series`
--

CREATE TABLE `series` (
  `series_id` int(11) NOT NULL,
  `seasonquantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `name`) VALUES
(1, 'eduardo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `watched`
--

CREATE TABLE `watched` (
  `id` int(11) NOT NULL,
  `id_material` int(11) NOT NULL,
  `id_element` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `watched`
--

INSERT INTO `watched` (`id`, `id_material`, `id_element`, `id_user`) VALUES
(1, 1, 6, 1),
(2, 1, 7, 1),
(3, 4, 2, 1),
(4, 4, 3, 1),
(5, 1, 10, 1),
(6, 1, 0, 1),
(7, 1, 0, 1),
(8, 1, 0, 1),
(9, 1, 0, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_id`),
  ADD KEY `fk_author_book` (`book_id`);

--
-- Indices de la tabla `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `chapter`
--
ALTER TABLE `chapter`
  ADD PRIMARY KEY (`chapter_id`),
  ADD KEY `fk_chapter_series` (`series`);

--
-- Indices de la tabla `magazine`
--
ALTER TABLE `magazine`
  ADD PRIMARY KEY (`magazine_id`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `page`
--
ALTER TABLE `page`
  ADD PRIMARY KEY (`page_id`);

--
-- Indices de la tabla `series`
--
ALTER TABLE `series`
  ADD PRIMARY KEY (`series_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `watched`
--
ALTER TABLE `watched`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `author`
--
ALTER TABLE `author`
  MODIFY `author_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `magazine`
--
ALTER TABLE `magazine`
  MODIFY `magazine_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `material`
--
ALTER TABLE `material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `page`
--
ALTER TABLE `page`
  MODIFY `page_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `watched`
--
ALTER TABLE `watched`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `author`
--
ALTER TABLE `author`
  ADD CONSTRAINT `fk_author_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `chapter`
--
ALTER TABLE `chapter`
  ADD CONSTRAINT `fk_chapter_series` FOREIGN KEY (`series`) REFERENCES `series` (`series_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
