/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50717
Source Host           : localhost:3307
Source Database       : maker

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-24 21:02:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ad_id` varchar(25) NOT NULL COMMENT 'Id',
  `ad_name` varchar(10) DEFAULT NULL COMMENT '用户名',
  `ad_phone` char(11) DEFAULT NULL COMMENT '电话',
  `ad_password` varchar(20) DEFAULT NULL COMMENT '密码',
  `ad_passwordmd5` varchar(50) DEFAULT NULL COMMENT 'md5加密的密码',
  `ad_truename` varchar(8) DEFAULT NULL COMMENT '真实姓名',
  `ad_idcard` varchar(25) DEFAULT NULL COMMENT '身份证',
  `ad_true` int(1) DEFAULT '1' COMMENT '是否实名',
  `ad_email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `ad_img` varchar(30) DEFAULT NULL COMMENT '头像',
  `ad_registime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ad_endtime` datetime DEFAULT NULL COMMENT '注销时间',
  `ad_start` int(1) DEFAULT '1' COMMENT '1正常0账号已注销',
  `ad_power` int(1) DEFAULT '1' COMMENT '1普通管理员',
  PRIMARY KEY (`ad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for developer
-- ----------------------------
DROP TABLE IF EXISTS `developer`;
CREATE TABLE `developer` (
  `dev_id` varchar(25) NOT NULL COMMENT '开发人员id（主键）',
  `dev_phone` char(11) DEFAULT NULL COMMENT '开发人员电话',
  `dev_name` varchar(8) DEFAULT NULL COMMENT '用户名',
  `dev_password` varchar(20) DEFAULT NULL COMMENT '开发人员登录密码',
  `dev_passwordmd5` varchar(50) DEFAULT NULL COMMENT '开发人员加密密码',
  `dev_number` char(15) DEFAULT NULL COMMENT '开发人员学号(如果是学生,就输入学号)',
  `dev_school` varchar(20) DEFAULT NULL COMMENT '开发人员学校名字(学生学校)',
  `dev_truename` varchar(8) DEFAULT NULL COMMENT '开发人员真实姓名',
  `dev_idcard` char(18) DEFAULT NULL COMMENT '开发人员的身份证号码',
  `dev_true` int(1) DEFAULT '0' COMMENT '0还没认证,1已认证',
  `dev_img` varchar(30) DEFAULT NULL COMMENT '开发人员的照片',
  `dev_email` varchar(20) DEFAULT NULL COMMENT '开发人员邮箱',
  `dev_location` varchar(20) DEFAULT NULL COMMENT '开发人员所在地',
  `dev_speciality` varchar(30) DEFAULT NULL COMMENT '开发人员的特长',
  `dev_info` text COMMENT '开发人员个人介绍',
  `dev_back` int(10) DEFAULT '0' COMMENT '差评总数',
  `dev_praise` int(10) DEFAULT '0' COMMENT '好评总数',
  `dev_registime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开发人员注册时间',
  `dev_idchange` int(1) DEFAULT '0' COMMENT '0未改过， 1 id已改过',
  `dev_cancellation` int(1) DEFAULT '0' COMMENT '默认0,1已注销',
  `dev_cancellationtime` datetime DEFAULT NULL COMMENT '注销时间',
  PRIMARY KEY (`dev_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开发人员表';

-- ----------------------------
-- Records of developer
-- ----------------------------
INSERT INTO `developer` VALUES ('Dev_123456', '15360776666', '156', '123456', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '0', null, null, '789', '1531', '佳之笔，请赐教，并在画中作上标记。\r\n\r\n　　晚上，画家取回画时，发现整个画面都涂满了记号，没有一笔一划不被指责的。画家心中十分不快，对这次尝试深感失望。\r\n\r\n　　画家决定换一种方式再去试试，于是他又摹了一张同样同样的画拿到市场上展出。可这一次，他要求每位观赏者将其最为欣赏的妙笔都标上记号。结果是，一切曾被指责的笔划，如今都换上了赞美的标记。\r\n\r\n　　最后，画家不无感慨地说：“我现在终于明白了，无论自己做什么，只要一部分人满意就足够了。因为，在有些人看来是丑的东西，在另一些人的眼里则恰恰是美好的”。\r\n\r\n　　现实生活中我们也常常遇见类似的事情，就如现在做淘宝店铺，即使是你免费送的东西，还有人嫌弃你送的东西太小了，或者一些别的评论，人总不会有满足的时候。现实生活中，什么样的人都有，即使你是好心，既便你尽了全力，但你还是不可能使所有的人都满意。\r\n\r\n　　你不能让所有人都满意，因为有时并不是所有人都是人。\r\n\r\n　　别人说的，让人去说，别人做的，让人去做。嘴巴长在人家的脸上，我们也控制不了。我们会继续以我们的服务对待我们的客户，自己做到了，别人如何去说，就是别人的事了。\r\n\r\n　　……\r\n\r\n　　一位上了年纪的父亲和他的小儿子一起赶着他们的驴子，打算到市场上去卖。他们没走多远，遇见了一群人聚集在井边，谈笑风生。\r\n\r\n　　其中有一个人说：“瞧，你们看见过这种人吗，放着驴子不骑，却要走路。”父亲听到此话，立刻叫儿子骑上驴去。\r\n\r\n　　走了一会儿，他们遇到了一群正在争吵的老头，其中一个老头说：“看看，这正证明了我刚说的那些话。现在这种社会时尚，根本谈不上什么尊敬老人。你们看看那懒惰的孩子骑在驴上，而他年迈的父亲却在下面行走。下来，你这小东西！还不让你年老的父亲歇歇他疲乏的腿！”父亲便叫儿子下来，自己骑上毛驴。\r\n\r\n　　他们没走多远，又遇到一群妇女，有一个妇女大喊道：“你这无用的老头，你怎么可以骑在驴子上，而让那可怜的孩子跑得一点力气都没啦？”父亲立刻又叫他儿子来坐在他后面，两个人合骑着一头毛驴。\r\n\r\n　　过了一会儿，来到一座教堂前，一位牧师叫住了他们：“喂！喂！请等一下，那么弱小的驴子让两个人骑，驴子太可怜了。你们要去那里呢？”“我们正要带这匹驴子去市场卖呀！”“哦！这更有问题。我看你们还没走进市场，驴子就先累死了，恐怕还卖不出去呢！”“那么，该怎么办呢？”“把驴子扛着去吧！”“好！就按照你说的办。”父子俩立刻从驴背上跳下来，将驴子的腿捆在一起，用一根木棍将驴子抬上肩向前走。经过市场附近的一座桥时，很多人围过来看这种有趣的事，大家都取笑他们父子俩。吵闹声和这种奇怪的摆弄使驴子很不高兴，它用力挣断了绳索和棍子，掉到河里去了。\r\n\r\n　　这个故事说明了这样一个道理：不同的人站在不同的立场，会有不同的看法。无论你怎样做，你都不可能做到让所有的人都满意。所以，做事要有主见，如果自己认为是正确的，就要坚持下去，不要被别人的意见所左右，不要企图让所有的人都满意。那位父亲想让所有的人都满意，结果谁都不满意，还把毛驴弄丢了。\r\n\r\n　　在做事的过程中，常会面对很多的批评与指责。\r\n\r\n　　想要让所有的人都赞美你、肯定你，那是不可能的，一个人的价值也不是寄托在他人的赞美或批评上，只要尽心尽力去做就好；至于其他人如何的批评、如何的期许，就不必太在意。\r\n\r\n　　一个人是不可能让所有人都对你满意，即使已经尽全力去做，还是会有让别人抱怨的地方。如果所的人都对你感到满意，反而表示你可能有问题。因为如果做坏事，好人会骂你；做好事，坏人会骂你。', '0', '1', '2018-11-08 15:27:53', '0', '0', null);
INSERT INTO `developer` VALUES ('Dev_fgbUllnr', '15360776123', '156', '123456', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '0', null, null, '789', '1531', '1564', '0', '2', '2018-11-05 19:12:00', '0', '0', null);
INSERT INTO `developer` VALUES ('Dev_fkPPOxJV', '15360776129', '156', '123456', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '0', null, null, '789', '1531', '1564', '0', '3', '2018-11-05 19:13:44', '0', '0', null);
INSERT INTO `developer` VALUES ('Dev_HwpaAovn', '15360776122', '156', '123456', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '0', null, null, '789', '1531', '1564', '0', '4', '2018-11-05 19:11:45', '0', '0', null);
INSERT INTO `developer` VALUES ('Dev_iApYabNi', '15360776124', '156', '123456', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '0', null, null, '789', '1531', '1564', '0', '5', '2018-11-05 19:12:26', '0', '0', null);
INSERT INTO `developer` VALUES ('Dev_ldjxvOUR', '15360776127', '156', '123456', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '0', null, null, '789', '1531', '1564', '0', '6', '2018-11-05 19:13:32', '0', '0', null);
INSERT INTO `developer` VALUES ('Dev_RjvEbuoa', '15360776112', '153', '123456', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '0', null, null, null, null, null, '0', '7', '2018-11-16 19:36:21', '0', '0', null);
INSERT INTO `developer` VALUES ('Dev_RjvEbuoe', '13437562202', '156', '123456', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '0', null, null, '789', '1531', '1564', '0', '8', '2018-11-05 19:01:42', '0', '0', null);
INSERT INTO `developer` VALUES ('Dev_ukPjoliN', '15360776126', '156', '123456', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '0', null, null, '789', '1531', '1564', '0', '9', '2018-11-05 19:12:48', '0', '0', null);
INSERT INTO `developer` VALUES ('Dev_UOzbFjZR', '15360776121', '13', '123456', 'e10adc3949ba59abbe56e057f20f883e', '123', '546', '123', '440921199712088033', '1', null, '231', '987', '654', '佳之笔，请赐教，并在画中作上标记。\r\n\r\n　　晚上，画家取回画时，发现整个画面都涂满了记号，没有一笔一划不被指责的。画家心中十分不快，对这次尝试深感失望。\r\n\r\n　　画家决定换一种方式再去试试，于是他又摹了一张同样同样的画拿到市场上展出。可这一次，他要求每位观赏者将其最为欣赏的妙笔都标上记号。结果是，一切曾被指责的笔划，如今都换上了赞美的标记。\r\n\r\n　　最后，画家不无感慨地说：“我现在终于明白了，无论自己做什么，只要一部分人满意就足够了。因为，在有些人看来是丑的东西，在另一些人的眼里则恰恰是美好的”。\r\n\r\n　　现实生活中我们也常常遇见类似的事情，就如现在做淘宝店铺，即使是你免费送的东西，还有人嫌弃你送的东西太小了，或者一些别的评论，人总不会有满足的时候。现实生活中，什么样的人都有，即使你是好心，既便你尽了全力，但你还是不可能使所有的人都满意。\r\n\r\n　　你不能让所有人都满意，因为有时并不是所有人都是人。\r\n\r\n　　别人说的，让人去说，别人做的，让人去做。嘴巴长在人家的脸上，我们也控制不了。我们会继续以我们的服务对待我们的客户，自己做到了，别人如何去说，就是别人的事了。\r\n\r\n　　……\r\n\r\n　　一位上了年纪的父亲和他的小儿子一起赶着他们的驴子，打算到市场上去卖。他们没走多远，遇见了一群人聚集在井边，谈笑风生。\r\n\r\n　　其中有一个人说：“瞧，你们看见过这种人吗，放着驴子不骑，却要走路。”父亲听到此话，立刻叫儿子骑上驴去。\r\n\r\n　　走了一会儿，他们遇到了一群正在争吵的老头，其中一个老头说：“看看，这正证明了我刚说的那些话。现在这种社会时尚，根本谈不上什么尊敬老人。你们看看那懒惰的孩子骑在驴上，而他年迈的父亲却在下面行走。下来，你这小东西！还不让你年老的父亲歇歇他疲乏的腿！”父亲便叫儿子下来，自己骑上毛驴。\r\n\r\n　　他们没走多远，又遇到一群妇女，有一个妇女大喊道：“你这无用的老头，你怎么可以骑在驴子上，而让那可怜的孩子跑得一点力气都没啦？”父亲立刻又叫他儿子来坐在他后面，两个人合骑着一头毛驴。\r\n\r\n　　过了一会儿，来到一座教堂前，一位牧师叫住了他们：“喂！喂！请等一下，那么弱小的驴子让两个人骑，驴子太可怜了。你们要去那里呢？”“我们正要带这匹驴子去市场卖呀！”“哦！这更有问题。我看你们还没走进市场，驴子就先累死了，恐怕还卖不出去呢！”“那么，该怎么办呢？”“把驴子扛着去吧！”“好！就按照你说的办。”父子俩立刻从驴背上跳下来，将驴子的腿捆在一起，用一根木棍将驴子抬上肩向前走。经过市场附近的一座桥时，很多人围过来看这种有趣的事，大家都取笑他们父子俩。吵闹声和这种奇怪的摆弄使驴子很不高兴，它用力挣断了绳索和棍子，掉到河里去了。\r\n\r\n　　这个故事说明了这样一个道理：不同的人站在不同的立场，会有不同的看法。无论你怎样做，你都不可能做到让所有的人都满意。所以，做事要有主见，如果自己认为是正确的，就要坚持下去，不要被别人的意见所左右，不要企图让所有的人都满意。那位父亲想让所有的人都满意，结果谁都不满意，还把毛驴弄丢了。\r\n\r\n　　在做事的过程中，常会面对很多的批评与指责。\r\n\r\n　　想要让所有的人都赞美你、肯定你，那是不可能的，一个人的价值也不是寄托在他人的赞美或批评上，只要尽心尽力去做就好；至于其他人如何的批评、如何的期许，就不必太在意。\r\n\r\n　　一个人是不可能让所有人都对你满意，即使已经尽全力去做，还是会有让别人抱怨的地方。如果所的人都对你感到满意，反而表示你可能有问题。因为如果做坏事，好人会骂你；做好事，坏人会骂你。', '0', '10', '2018-11-05 19:11:22', '0', '0', '2018-11-21 22:16:14');
INSERT INTO `developer` VALUES ('Dev_yfSYQTeN', '15360776128', '156', '123456', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '0', null, null, '789', '1531', '1564', '0', '11', '2018-11-05 19:13:39', '0', '0', null);

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `forum_id` varchar(25) NOT NULL COMMENT '讲堂内容id',
  `forummem_id` varchar(25) DEFAULT NULL COMMENT '作者id',
  `forum_what` int(1) DEFAULT NULL COMMENT '1是视频，2是文字作品',
  `forum_route` varchar(50) DEFAULT NULL COMMENT '视频物理路径',
  `forum_forid` varchar(25) DEFAULT NULL COMMENT '转发的作品id',
  `forum_name` varchar(10) DEFAULT NULL COMMENT '作品标题名称',
  `forum_type` varchar(10) DEFAULT NULL COMMENT '类型',
  `forum_info` text COMMENT '作品详细介绍',
  `forum_textAfter` text COMMENT '文字作品显示的内容',
  `forum_text` text COMMENT '文字作品原来的内容',
  `forum_reltime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `forum_heat` int(6) DEFAULT '0' COMMENT '热度',
  `forum_start` int(1) DEFAULT '0' COMMENT '0保存未发布,1已发布,2已删除',
  PRIMARY KEY (`forum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='讲堂的作品';

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES ('For_123456', 'Dev_RjvEbuoe', '2', null, null, '大叔大婶大所多12', '14721', '奥术大师大所大17', null, '奥术大师大所17123456', '2018-11-06 23:24:32', '45', '1');
INSERT INTO `forum` VALUES ('For_aZNagasd', 'Dev_RjvEbuoe', '2', '', null, '第三方第三方是', 'java', '', null, '', '2018-11-01 10:41:04', '41', '1');
INSERT INTO `forum` VALUES ('For_aZNagXOs', 'Dev_RjvEbuoe', '2', null, null, '第三方第三方是', 'java', null, null, null, '2018-11-01 10:41:04', '41', '1');
INSERT INTO `forum` VALUES ('For_bHcqlxTx', 'Dev_RjvEbuoe', null, null, 'For_YMntXobI', null, null, null, null, null, '2018-11-24 18:31:15', '0', '0');
INSERT INTO `forum` VALUES ('For_FwiUHWcW', 'Dev_123456', '2', null, null, '第三方水电费速度', '283', '发的个非官方大哥', null, '讽德诵功电饭锅梵蒂冈梵蒂冈讽德诵功梵蒂冈梵蒂冈', '2018-11-01 09:32:03', '41', '1');
INSERT INTO `forum` VALUES ('For_gimKDWZG', 'Dev_RjvEbuoe', '2', null, null, '自行车自行车自行车', null, '重新注册自行车自行车自行车注销', '<p>**奥术大师大所大所大_大萨达大所大所大所多</p>\n<h3>倒萨大大大大**从自行车自行车在线- 大叔大婶大所大所大所大所1. 阿萨德撒大所大所多撒多```</h3>\n<p>奥术大师大所大所大所多1. 奥术大师大所大所大所多奥术大师大所大所大1. 奥术大师大所大所大<em>大萨达所大所大所大</em>实打实大所大<strong>奥术大师大所大所大所</strong>__\n```<strong>奥术大师大所大所大所多1. 奥术大师大所大所大所多奥术大师大所大所大1. 奥术大师大所大所大<em>大萨达所大所大所大</em>实打实大所大</strong>奥术大师大所大所大所<strong><strong>奥术大师大所大所大所多1. 奥术大师大所大所大所多奥术大师大所大所大1. 奥术大师大所大所大<em>大萨达所大所大所大</em>实打实大所大<strong>奥术大师大所大所大所</strong></strong>奥术大师大所大所大所多1. 奥术大师大所大所大所多奥术大师大所大所大1. 奥术大师大所大所大<em>大萨达所大所大所大</em>实打实大所大</strong>奥术大师大所大所大所<strong><strong>奥术大师大所大所大所多1. 奥术大师大所大所大所多奥术大师大所大所大1. 奥术大师大所大所大<em>大萨达所大所大所大</em>实打实大所大<strong>奥术大师大所大所大所</strong></strong>_</strong></p>\n', '**奥术大师大所大所大_大萨达大所大所大所多\n\n### 倒萨大大大大**从自行车自行车在线- 大叔大婶大所大所大所大所1. 阿萨德撒大所大所多撒多```\n奥术大师大所大所大所多1. 奥术大师大所大所大所多奥术大师大所大所大1. 奥术大师大所大所大_大萨达所大所大所大_实打实大所大**奥术大师大所大所大所**__\n```**奥术大师大所大所大所多1. 奥术大师大所大所大所多奥术大师大所大所大1. 奥术大师大所大所大_大萨达所大所大所大_实打实大所大**奥术大师大所大所大所**__奥术大师大所大所大所多1. 奥术大师大所大所大所多奥术大师大所大所大1. 奥术大师大所大所大_大萨达所大所大所大_实打实大所大**奥术大师大所大所大所**__奥术大师大所大所大所多1. 奥术大师大所大所大所多奥术大师大所大所大1. 奥术大师大所大所大_大萨达所大所大所大_实打实大所大**奥术大师大所大所大所**__奥术大师大所大所大所多1. 奥术大师大所大所大所多奥术大师大所大所大1. 奥术大师大所大所大_大萨达所大所大所大_实打实大所大**奥术大师大所大所大所**___**', '2018-11-22 18:24:31', '41', '1');
INSERT INTO `forum` VALUES ('For_ksJOTPas', 'Dev_RjvEbuoe', '2', null, null, '', '', '', null, '', '2018-11-16 21:01:48', '42', '0');
INSERT INTO `forum` VALUES ('For_ksJOTPeY', 'Dev_123456', '2', null, null, '123fsf1231', 'asdfds4564', 'dsfads', null, 'sdfsdf123', '2018-11-01 09:42:06', '47', '1');
INSERT INTO `forum` VALUES ('For_lWkvyaxr', 'Dev_RjvEbuoe', '1', 'For_lWkvyaxr.mp4', null, '123', 'java', null, null, null, '2018-11-19 13:22:36', '44', '1');
INSERT INTO `forum` VALUES ('For_YMntXobI', 'Dev_RjvEbuoe', '1', 'For_YMntXobI.mp4', null, '123', 'sql', null, null, null, '2018-11-19 13:26:55', '46', '1');
INSERT INTO `forum` VALUES ('For_zUridcAe', 'Dev_RjvEbuoe', '2', '', null, '123', '', '', null, '', '2018-10-31 23:44:15', '41', '1');
INSERT INTO `forum` VALUES ('For_zUridcAm', 'Dev_RjvEbuoe', '2', null, null, '123', 'java', '对方水电费', null, '水电费', '2018-10-31 23:44:15', '41', '1');
INSERT INTO `forum` VALUES ('For_zUridcAp', 'Dev_RjvEbuoe', '2', '', null, '123', '', '', null, '', '2018-10-31 23:44:15', '41', '1');
INSERT INTO `forum` VALUES ('For_zUridcAq', 'Dev_RjvEbuoe', '2', '', null, '123', '', '', null, '', '2018-10-31 23:44:15', '41', '1');
INSERT INTO `forum` VALUES ('For_zUridcAr', 'Dev_RjvEbuoe', '2', '', null, '123', '', '', null, '', '2018-10-31 23:44:15', '42', '1');
INSERT INTO `forum` VALUES ('For_zUridcAt', 'Dev_RjvEbuoe', '2', '', null, '123', '', '', null, '', '2018-10-31 23:44:15', '42', '0');
INSERT INTO `forum` VALUES ('For_zUridcAu', 'Dev_RjvEbuoe', '2', '', null, '123', '', '', null, '', '2018-10-31 23:44:15', '41', '0');
INSERT INTO `forum` VALUES ('For_zUridcAw', 'Dev_RjvEbuoe', '2', '', null, '123', 'php', '电视台风格让他而', null, ' 水电费第三方沙发斯蒂芬', '2018-10-31 23:44:15', '41', '0');
INSERT INTO `forum` VALUES ('For_zUridcAy', 'Dev_RjvEbuoe', '2', '', null, '123', '', '', null, '', '2018-10-31 23:44:15', '41', '0');

-- ----------------------------
-- Table structure for forumimg
-- ----------------------------
DROP TABLE IF EXISTS `forumimg`;
CREATE TABLE `forumimg` (
  `img_id` varchar(25) NOT NULL COMMENT '图片Id',
  `img_route` varchar(50) DEFAULT NULL COMMENT '图片路径',
  `img_rectime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `img_authorId` varchar(30) DEFAULT NULL COMMENT '发布人Id',
  `img_size` double(50,0) DEFAULT NULL COMMENT '图片的大小',
  `img_start` int(1) DEFAULT '2' COMMENT '图片状态(1不可用,2可用)',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作品的图片库';

-- ----------------------------
-- Records of forumimg
-- ----------------------------
INSERT INTO `forumimg` VALUES ('Img_HjltVcfx', 'fd2b24f3-232c-4cf3-9e25-835353fbab10.jpg', '2018-11-19 21:24:20', 'Dev_RjvEbuoe', '33555', '2');
INSERT INTO `forumimg` VALUES ('Img_JimibLgr', '9ea81917-c9f1-4896-9c42-ac0c289f393a.jpg', '2018-11-19 21:15:41', 'Dev_RjvEbuoe', '33555', '2');
INSERT INTO `forumimg` VALUES ('Img_KtyayQwB', '98901cad-4f5d-4dc5-8e71-dd66ed5c8338.jpg', '2018-11-19 21:16:33', 'Dev_RjvEbuoe', '33555', '2');
INSERT INTO `forumimg` VALUES ('Img_lXtVWAMa', '4a20ea54-8694-484c-902b-2872b6342b65.jpg', '2018-11-19 21:19:59', 'Dev_RjvEbuoe', '33555', '2');
INSERT INTO `forumimg` VALUES ('Img_QpnmuvEM', '33cdaf54-0547-4d4c-931e-8d7ab17106f6.jpg', '2018-11-19 21:41:12', 'Dev_RjvEbuoe', '33555', '2');
INSERT INTO `forumimg` VALUES ('Img_sChGysjy', '4e2a95ce-124f-48ab-b606-79e1508ff027.jpg', '2018-11-19 21:11:00', 'Dev_RjvEbuoe', '33555', '2');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `position_id` varchar(25) NOT NULL COMMENT '职位id',
  `position_name` varchar(10) DEFAULT NULL COMMENT '职位名称',
  `positionmem_id` varchar(25) DEFAULT NULL COMMENT '发布人id',
  `position_reltime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `position_endtime` datetime DEFAULT NULL COMMENT '结束时间',
  `position_amount` int(5) DEFAULT NULL COMMENT '职位招的人数',
  `position_info` text COMMENT '职位介绍',
  `position_heat` int(6) DEFAULT NULL COMMENT '热度',
  `position_state` int(1) DEFAULT '1' COMMENT '未发布1，发布2，招满结束3',
  `position_type` varchar(20) DEFAULT NULL COMMENT '职位类型',
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位信息';

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('Pos_bkXBnbur', 'java', 'Dev_RjvEbuoe', '2018-10-25 16:44:20', '2018-11-25 00:00:00', '3', '胜多负少大付付付付付', '15', '2', null);
INSERT INTO `position` VALUES ('Pos_dYOctAzs', 'java', 'Dev_RjvEbuoe', '2018-10-25 16:33:31', '2018-11-25 13:36:46', '3', null, '2', '2', null);
INSERT INTO `position` VALUES ('Pos_hguSoLHt', 'asdasdas', 'Dev_RjvEbuoe', '2018-11-16 18:13:22', '2018-11-21 18:06:56', '12', 'asdasdasdas', '3', '1', null);
INSERT INTO `position` VALUES ('Pos_IMzSpBvr', '123', 'Dev_RjvEbuoe', '2018-10-25 13:36:46', null, '3', null, '4', '2', null);
INSERT INTO `position` VALUES ('Pos_KOLLXhKn', 'java', 'Dev_RjvEbuoe', '2018-10-25 16:43:43', '2018-11-25 00:00:00', '3', '胜多负少大付付付付付', '5', '2', null);
INSERT INTO `position` VALUES ('Pos_lJGRtTpV', 'java', 'Dev_RjvEbuoe', '2018-10-25 16:41:52', null, '3', null, '6', '2', null);
INSERT INTO `position` VALUES ('Pos_NkYKwOYu', 'java', 'Dev_RjvEbuoe', '2018-10-25 16:43:20', '2018-11-25 00:00:00', '3', '胜多负少大付付付付付', '7', '2', null);
INSERT INTO `position` VALUES ('Pos_RpNdmdeq', 'php', 'Dev_HwpaAovn', '2018-11-08 11:41:28', null, '0', null, '8', '2', null);
INSERT INTO `position` VALUES ('Pos_RpNdmdeZ', '123', 'Dev_RjvEbuoe', '2018-10-25 16:32:42', '2018-10-25 13:36:46', '3', null, '10', '2', null);
INSERT INTO `position` VALUES ('Pos_RpNdmdOP', '123', 'Dev_RjvEbuoe', '2018-11-13 21:24:13', null, '0', null, '10', '1', null);

-- ----------------------------
-- Table structure for positionmem
-- ----------------------------
DROP TABLE IF EXISTS `positionmem`;
CREATE TABLE `positionmem` (
  `position_id` varchar(25) DEFAULT NULL COMMENT '职位id',
  `positionmem_id` varchar(25) DEFAULT NULL COMMENT '申请人id',
  `positionmem_state` int(1) DEFAULT '1' COMMENT '职位状态(0撤销申请1申请，2录取,3辞职)',
  `positionmem_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `positionmen_reltime` datetime DEFAULT NULL COMMENT '申请成功时间',
  `positionmen_endime` datetime DEFAULT NULL COMMENT '辞职时间',
  `positionmen_sum` int(6) DEFAULT NULL COMMENT '标识码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线求职的人';

-- ----------------------------
-- Records of positionmem
-- ----------------------------
INSERT INTO `positionmem` VALUES ('Pos_bkXBnbur', 'Dev_fgbUllnr', '0', '2018-11-08 12:15:09', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_dYOctAzs', 'Dev_fkPPOxJV', '0', '2018-11-08 12:15:10', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_IMzSpBvr', 'Dev_HwpaAovn', '0', '2018-11-08 12:15:10', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_KOLLXhKn', 'Dev_iApYabNi', '0', '2018-11-08 12:15:10', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_lJGRtTpV', 'Dev_ldjxvOUR', '0', '2018-11-08 12:15:10', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_NkYKwOYu', 'Dev_RjvEbuoe', '0', '2018-11-08 12:15:10', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_RpNdmdeZ', 'Dev_ukPjoliN', '0', '2018-11-08 12:15:11', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_RpNdmdeq', 'Dev_UOzbFjZR', '0', '2018-11-08 12:15:11', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_IMzSpBvr', 'Dev_yfSYQTeN', '0', '2018-11-08 12:15:11', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_KOLLXhKn', 'Dev_fgbUllnr', '0', '2018-11-08 12:15:11', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_lJGRtTpV', 'Dev_fkPPOxJV', '0', '2018-11-08 12:15:12', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_RpNdmdOP', 'Dev_fgbUllnr', '1', '2018-11-13 21:27:03', null, null, null);
INSERT INTO `positionmem` VALUES ('Pos_RpNdmdOP', 'Dev_iApYabNi', '0', '2018-11-13 22:20:39', null, null, null);

-- ----------------------------
-- Table structure for prodeta
-- ----------------------------
DROP TABLE IF EXISTS `prodeta`;
CREATE TABLE `prodeta` (
  `pro_id` varchar(25) DEFAULT NULL COMMENT '项目id',
  `prde_iswin` varchar(25) DEFAULT NULL COMMENT '项目中标者',
  `prde_rectime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '竞标成功的时间',
  `prde_comtime` datetime DEFAULT NULL COMMENT '项目已完成时间',
  `prde_state` int(1) DEFAULT '1' COMMENT '发布人是否确认验收（默认1未验收，2已验收3未达到条件已回）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目订单信息表';

-- ----------------------------
-- Records of prodeta
-- ----------------------------
INSERT INTO `prodeta` VALUES ('Pro_nCjiDWUa', 'Dev_RjvEbuoe', '2018-07-05 19:21:25', null, '1');
INSERT INTO `prodeta` VALUES ('Pro_nvUIGsBk', 'Stu_ERCYpGQy', '2018-07-05 19:24:23', null, '2');
INSERT INTO `prodeta` VALUES ('Pro_CMyloCbL', 'Stu_ERCYpGQr', '2018-11-08 12:36:43', null, '1');
INSERT INTO `prodeta` VALUES ('Pro_fEuFvXXA', 'Stu_ERCYpGQe', '2018-11-08 12:36:44', null, '1');
INSERT INTO `prodeta` VALUES ('Pro_GttSCLvZ', 'Stu_ERCYpGQw', '2018-11-08 12:36:44', null, '1');
INSERT INTO `prodeta` VALUES ('Pro_iAEoalvC', 'Dev_fgbUllnr', '2018-11-08 12:36:45', null, '1');
INSERT INTO `prodeta` VALUES ('Pro_LAgGFiJv', 'Dev_fkPPOxJV', '2018-11-08 12:36:45', null, '1');
INSERT INTO `prodeta` VALUES ('Pro_nCjiDWUa', 'Dev_HwpaAovn', '2018-11-08 12:36:46', null, '1');

-- ----------------------------
-- Table structure for prodetamem
-- ----------------------------
DROP TABLE IF EXISTS `prodetamem`;
CREATE TABLE `prodetamem` (
  `pro_id` varchar(25) DEFAULT NULL COMMENT '项目id',
  `prdemem_id` varchar(25) DEFAULT NULL COMMENT '竞标的开发人员id或工作室id',
  `prdemem_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '竞标时间',
  `prdemem_state` int(1) DEFAULT '1' COMMENT '是否竞标成功（0撤销,默认1只是表示参加,2成功）',
  `prdemem_sum` int(6) DEFAULT NULL COMMENT '标识码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目的参加竞标人员（工作室）';

-- ----------------------------
-- Records of prodetamem
-- ----------------------------
INSERT INTO `prodetamem` VALUES ('Pro_CMyloCbL', 'Stu_ERCYpGQy', '2018-11-04 23:26:10', '1', null);
INSERT INTO `prodetamem` VALUES ('Pro_fEuFvXXA', 'Stu_ERCYpGQr', '2018-11-04 23:26:16', '1', null);
INSERT INTO `prodetamem` VALUES ('Pro_GttSCLvZ', 'Stu_ERCYpGQe', '2018-11-08 12:33:44', '1', null);
INSERT INTO `prodetamem` VALUES ('Pro_iAEoalvC', 'Stu_ERCYpGQw', '2018-11-08 12:33:45', '1', null);
INSERT INTO `prodetamem` VALUES ('Pro_LAgGFiJv', 'Dev_fgbUllnr', '2018-11-08 12:33:45', '1', null);
INSERT INTO `prodetamem` VALUES ('Pro_nCjiDWUa', 'Dev_fkPPOxJV', '2018-11-08 12:33:46', '1', null);
INSERT INTO `prodetamem` VALUES ('Pro_nCjiDWUp', 'Dev_HwpaAovn', '2018-11-08 12:33:47', '1', null);
INSERT INTO `prodetamem` VALUES ('Pro_nCjiDWUR', 'Dev_iApYabNi', '2018-11-08 12:33:48', '1', null);
INSERT INTO `prodetamem` VALUES ('Pro_CMyloCbL', 'Dev_ldjxvOUR', '2018-11-08 12:33:54', '1', null);
INSERT INTO `prodetamem` VALUES ('Pro_CMyloCbL', 'Dev_RjvEbuoe', '2018-11-09 00:00:31', '1', null);

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `pro_id` varchar(25) NOT NULL COMMENT '项目id（主键）',
  `pro_publisher` varchar(25) DEFAULT NULL COMMENT '项目的发布人（开发人员id或工作室id）',
  `pro_pubname` varchar(8) DEFAULT NULL COMMENT '发布人的真实姓名（工作室的名字）',
  `pro_name` varchar(10) DEFAULT NULL COMMENT '项目的标题',
  `pro_type` varchar(30) DEFAULT NULL COMMENT '项目的类型(例如java,php等等)',
  `pro_money` double(10,0) DEFAULT NULL COMMENT '项目的薪酬',
  `pro_info` text COMMENT '项目的详细信息',
  `pro_foutime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '项目创建时间',
  `pro_reltime` datetime DEFAULT NULL COMMENT '项目发布时间',
  `pro_endtime` datetime DEFAULT NULL COMMENT '项目结束时间',
  `pro_city` varchar(10) DEFAULT NULL COMMENT '项目发布城市',
  `pro_heat` int(7) DEFAULT '0' COMMENT '项目人气',
  `pro_state` int(1) DEFAULT '0' COMMENT '项目状态（0未发布1已发布, 2已接单，3已完成4等待检验5已通过检验,6.已删除）',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目信息表';

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('Pro_AOKFrMRa', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '1239', '大叔大婶', '2018-11-18 20:34:54', '2018-11-24 20:09:20', '2018-11-14 15:45:27', '杭州市', '12', '2');
INSERT INTO `project` VALUES ('Pro_CMyloCbL', 'Dev_RjvEbuoe', '1', '大大', 'java、mysql', '123123', '大萨达所大所大所大', '2018-11-07 00:23:25', '2018-11-16 18:43:52', '2018-11-21 00:23:01', '广州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_CzTyrTol', 'Dev_RjvEbuoe', null, '法第三方士大夫', 'java、php', '1238', '发个梵蒂冈地方公司的', '2018-11-18 20:25:39', '2018-11-18 20:25:39', '2018-11-17 20:25:13', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_evagFIOD', 'Dev_RjvEbuoe', null, '法第三方士大夫', 'java、php', '1237', '发个梵蒂冈地方公司的', '2018-11-18 20:25:40', '2018-11-18 20:25:40', '2018-11-17 20:25:13', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_fbPhmGCU', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '1236', '大叔大婶', '2018-11-18 20:34:47', '2018-11-18 20:34:47', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_hhiWaZaA', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '1235', '大叔大婶', '2018-11-18 20:34:46', '2018-11-18 20:34:46', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_iEZgzOzb', 'Dev_RjvEbuoe', null, '法第三方士大夫', 'java、php', '1234', '发个梵蒂冈地方公司的', '2018-11-18 20:25:45', '2018-11-18 20:25:45', '2018-11-17 20:25:13', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_KNCiGmOW', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '1233', '大叔大婶', '2018-11-18 20:34:45', '2018-11-18 20:34:45', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_kxmBVqnb', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '1232', '大叔大婶', '2018-11-18 20:34:44', '2018-11-18 20:34:44', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_MvNzYtgE', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '1231', '大叔大婶', '2018-11-18 20:34:57', '2018-11-18 20:34:57', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_mzTHuCJb', 'Dev_RjvEbuoe', null, '法第三方士大夫', 'java、php', '1230', '发个梵蒂冈地方公司的', '2018-11-18 20:25:34', '2018-11-18 20:25:34', '2018-11-17 20:25:13', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_OCiIJkXu', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:53', '2018-11-18 20:34:53', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_OScJZvks', 'Dev_RjvEbuoe', null, '法第三方士大夫', 'java、php', '123', '发个梵蒂冈地方公司的', '2018-11-18 20:25:43', '2018-11-18 20:25:43', '2018-11-17 20:25:13', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_OYPKbDbt', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:52', '2018-11-18 20:34:52', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_pbhayFkJ', 'Dev_RjvEbuoe', null, '佛挡杀佛', 'java、php', '123', '水电费水电费地方', '2018-11-18 20:24:32', '2018-11-18 20:24:32', '2018-11-17 20:24:13', '无锡市', '0', '1');
INSERT INTO `project` VALUES ('Pro_peMMVXwT', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:42', '2018-11-18 20:34:42', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_QaTvBFhX', 'Dev_RjvEbuoe', null, '第三方广东省', 'java、php、mysql', '123', '是豆腐干豆腐三个地方', '2018-11-18 16:14:53', null, '1899-12-06 00:00:00', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_RgBxwcZt', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:48', '2018-11-18 20:34:48', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_RKMWBFJD', 'Dev_RjvEbuoe', null, '法第三方士大夫', 'java、php', '123', '发个梵蒂冈地方公司的', '2018-11-18 20:25:46', '2018-11-18 20:25:46', '2018-11-17 20:25:13', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_rpWXKoMH', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:39', null, '2018-11-14 15:45:27', '杭州市', '0', '0');
INSERT INTO `project` VALUES ('Pro_shLQiMKc', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:50', '2018-11-18 20:34:50', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_SkmDidVc', 'Dev_RjvEbuoe', null, '法第三方士大夫', 'java、php', '123', '发个梵蒂冈地方公司的', '2018-11-18 20:25:36', '2018-11-18 20:25:36', '2018-11-17 20:25:13', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_sNVLKzXw', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:59', '2018-11-18 20:34:59', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_TbRNUltn', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:58', '2018-11-18 20:34:58', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_TrHVchSE', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:40', null, '2018-11-14 15:45:27', '杭州市', '0', '0');
INSERT INTO `project` VALUES ('Pro_tXgodwXW', 'Dev_RjvEbuoe', null, '法第三方士大夫', 'java、php', '123', '发个梵蒂冈地方公司的', '2018-11-18 20:25:31', '2018-11-18 20:25:31', '2018-11-17 20:25:13', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_uLrwqNoS', 'Dev_RjvEbuoe', null, '发给大人', 'sdf、java、php', '1231', '第三方地方是否', '2018-11-18 20:24:12', '2018-11-18 20:24:12', '2018-11-10 20:23:48', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_wWxyHNry', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:35:00', '2018-11-18 20:35:00', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_XJmxmwow', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:35:01', '2018-11-18 20:35:01', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_xywTZZko', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:56', '2018-11-18 20:34:56', '2018-11-14 15:45:27', '杭州市', '0', '1');
INSERT INTO `project` VALUES ('Pro_YiYhXScP', 'Dev_RjvEbuoe', null, '法第三方士大夫', 'java、php', '123', '发个梵蒂冈地方公司的', '2018-11-18 20:25:37', '2018-11-18 20:25:37', '2018-11-17 20:25:13', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_YVxmYfkE', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:37', null, '2018-11-14 15:45:27', '杭州市', '0', '0');
INSERT INTO `project` VALUES ('Pro_yxVxMhBW', 'Dev_RjvEbuoe', null, '法第三方士大夫', 'java、php', '123', '发个梵蒂冈地方公司的', '2018-11-18 20:25:42', '2018-11-18 20:25:42', '2018-11-17 20:25:13', '天津市', '0', '1');
INSERT INTO `project` VALUES ('Pro_zdiVhSVu', 'Dev_RjvEbuoe', null, '暗示着自行车', 'sdf、java、php', '123', '大叔大婶', '2018-11-18 20:34:49', '2018-11-18 20:34:49', '2018-11-14 15:45:27', '杭州市', '0', '1');

-- ----------------------------
-- Table structure for studio
-- ----------------------------
DROP TABLE IF EXISTS `studio`;
CREATE TABLE `studio` (
  `stu_id` varchar(25) NOT NULL COMMENT '工作室id',
  `dev_id` varchar(25) DEFAULT NULL COMMENT '负责人id',
  `stu_name` varchar(10) DEFAULT NULL COMMENT '工作室名称',
  `stu_img` varchar(30) DEFAULT NULL,
  `stu_phone` char(11) DEFAULT NULL COMMENT '工作室电话',
  `stu_email` varchar(20) DEFAULT NULL COMMENT '工作室邮箱',
  `stu_location` varchar(10) DEFAULT NULL COMMENT '工作室所在地',
  `stu_speciality` varchar(50) DEFAULT NULL COMMENT '工作室的特长',
  `stu_info` text COMMENT '工作室介绍',
  `stu_start` int(1) DEFAULT '1' COMMENT '注销： 0,正常：1',
  `stu_praise` int(5) DEFAULT '0' COMMENT '点赞数',
  `stu_endtime` datetime DEFAULT NULL COMMENT '工作室注销时间',
  `stu_registime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '工作室创建时间',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作室信息表';

-- ----------------------------
-- Records of studio
-- ----------------------------
INSERT INTO `studio` VALUES ('Stu_ERCYpGQe', 'Dev_fgbUllnr', '3', null, null, null, 'guangdong', '156', '123456', '1', '1', null, '2018-11-05 19:21:47');
INSERT INTO `studio` VALUES ('Stu_ERCYpGQr', 'Dev_HwpaAovn', '2', null, null, null, 'guangdong', '156', '123456', '1', '2', null, '2018-11-05 19:21:35');
INSERT INTO `studio` VALUES ('Stu_ERCYpGQw', 'Dev_iApYabNi', '4', null, null, null, 'guangdong', '156', '123456', '1', '3', null, '2018-11-05 19:22:19');
INSERT INTO `studio` VALUES ('Stu_ERCYpGQX', 'Dev_RjvEbuoe', '123', null, '15361234567', '123456@qq.com', '广东', '400', '撒打发第三方噶大概', '1', '4', '2018-11-16 20:13:48', '2018-11-05 20:01:36');
INSERT INTO `studio` VALUES ('Stu_ERCYpGQy', 'Dev_RjvEbuoa', '1', null, null, null, 'guangdong', '156', '123456', '1', '5', null, '2018-11-05 19:21:21');

-- ----------------------------
-- Table structure for studiomem
-- ----------------------------
DROP TABLE IF EXISTS `studiomem`;
CREATE TABLE `studiomem` (
  `stumem_sum` int(6) DEFAULT NULL COMMENT '标记符号',
  `stu_id` varchar(25) NOT NULL COMMENT '工作室id',
  `dev_id` varchar(25) NOT NULL COMMENT '开发成员id',
  `stumem_power` int(1) DEFAULT '0' COMMENT '权力（0无权利,1是普通成员，2是组长,3负责人）',
  `stumem_is` int(1) DEFAULT '1' COMMENT '是否被负责人批准入工作室（0撤销,1 等待批准，2已批准,3拒绝,4退出,5删除记录6拉黑,7工作室已注销）',
  `stumem_time` timestamp NULL DEFAULT NULL COMMENT '开发人员入会时间',
  `stumem_registime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作室成员表';

-- ----------------------------
-- Records of studiomem
-- ----------------------------
INSERT INTO `studiomem` VALUES ('1', 'Stu_ERCYpGQe', 'Dev_yfSYQTeN', '0', '1', null, '2018-11-09 20:09:01');
INSERT INTO `studiomem` VALUES ('1', 'Stu_ERCYpGQX', 'Dev_RjvEbuoe', '1', '4', null, '2018-11-09 20:09:01');
INSERT INTO `studiomem` VALUES ('1', 'Stu_ERCYpGQr', 'Dev_yfSYQTeN', '2', '2', '2018-11-15 19:24:24', '2018-11-09 20:09:01');
INSERT INTO `studiomem` VALUES ('1', 'Stu_ERCYpGQw', 'Dev_RjvEbuoe', '1', null, null, '2018-11-09 20:09:01');
INSERT INTO `studiomem` VALUES ('2', 'Stu_ERCYpGQX', 'Dev_RjvEbuoe', '3', '0', null, '2018-11-09 20:09:01');
INSERT INTO `studiomem` VALUES ('1', 'Stu_ERCYpGQy', 'Dev_RjvEbuoe', '0', '0', '2018-11-05 20:01:36', '2018-11-09 20:09:01');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `tp_id` varchar(3) NOT NULL COMMENT '类型Id',
  `tp_name` varchar(10) DEFAULT NULL COMMENT '类型名字',
  `tp_career` varchar(10) DEFAULT NULL COMMENT '职业名称',
  `tp_style` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`tp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类型表';

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('123', 'sdf', '1', '1');
INSERT INTO `type` VALUES ('283', 'java', '2', '2');
INSERT INTO `type` VALUES ('400', 'php', '2', '2');
INSERT INTO `type` VALUES ('434', 'mysql', '2', '2');
INSERT INTO `type` VALUES ('486', 'jsq', '2', '2');
INSERT INTO `type` VALUES ('580', 'jsw', '2', '2');
INSERT INTO `type` VALUES ('589', 'jse', '2', '2');
INSERT INTO `type` VALUES ('625', 'jsr', '2', '2');
INSERT INTO `type` VALUES ('646', 'jst', '2', '2');
INSERT INTO `type` VALUES ('78', 'dfsd', '1', '2');
INSERT INTO `type` VALUES ('852', 'jsy', '2', '2');
INSERT INTO `type` VALUES ('972', 'jsj', '2', '2');
INSERT INTO `type` VALUES ('973', 'jsf', '2', '2');

-- ----------------------------
-- Table structure for typedata
-- ----------------------------
DROP TABLE IF EXISTS `typedata`;
CREATE TABLE `typedata` (
  `tp_id` varchar(5) DEFAULT NULL COMMENT '类型Id',
  `tpda_id` varchar(25) DEFAULT NULL COMMENT '包含这类型的数据(项目/开发人员)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类型数据表';

-- ----------------------------
-- Records of typedata
-- ----------------------------
