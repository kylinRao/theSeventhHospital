CREATE TABLE `cat_game_user` (
  `catUserId` int(11) NOT NULL auto_increment,
  `telephone` varchar(255) default NULL,
  `IMEI` varchar(255) default NULL,
  `createTime` date default NULL,
  PRIMARY KEY  (`catUserId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

CREATE TABLE `game_processing` (
  `gameId` int(11) NOT NULL auto_increment,
  `catUserId` int(11) default NULL,
  `catSlaveUserId` int(11) default NULL,
  `createTime` date default NULL,
  `endTime` date default NULL,
  PRIMARY KEY  (`gameId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='进行中游戏汇总表';
