/*
Navicat MySQL Data Transfer

Source Server         : master
Source Server Version : 50633
Source Host           : 192.168.1.99:3306
Source Database       : landbigdata

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-12-30 17:14:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for algorithm
-- ----------------------------
DROP TABLE IF EXISTS `algorithm`;
CREATE TABLE `algorithm` (
  `algorithm_id` int(11) NOT NULL,
  `algorithm_name` varchar(255) DEFAULT NULL,
  `algorithm_describe` text,
  `algorithm_tip` text,
  `algorithm_cmd` varchar(255) DEFAULT NULL,
  `algorithm_author` varchar(255) DEFAULT NULL,
  `algorithm_time` datetime DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `package_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`algorithm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of algorithm
-- ----------------------------
INSERT INTO `algorithm` VALUES ('1', 'K-Means', 'K-means算法是硬聚类算法，是典型的基于原型的目标函数聚类方法的代表，它是数据点到原型的某种距离作为优化的目标函数，利用函数求极值的方法得到迭代运算的调整规则。K-means算法以欧式距离作为相似度测度，它是求对应某一初始聚类中心向量V最优分类，使得评价指标J最小。算法采用误差平方和准则函数作为聚类准则函数。', '1. &nbsp;上传文件的格式为:</br>\r\r\n x1 x2 x3 x4...</br>\r\r\n y1 y2 y3 y4...</br>\r\r\n ...</br>\r\r\n2. &nbsp;在上传文件的首行添加命令及参数, 命令和参数的格式为：</br>\r\r\nmahout kmeans</br>\r\r\n -i (input vectors directory)</br>\r\r\n -c (input clusters directory)</br>\r\r\n -o (output working directory)</br>\r\r\n -k (optional number of initial clusters to sample from input vectors)</br>\r\r\n -dm (DistanceMeasure)</br>\r\r\n -x (maximum number of iterations)</br>\r\r\n -cd (optional convergence delta. Default is 0.5)</br>\r\r\n -ow (overwrite output directory if present)</br>\r\r\n -cl (run input vector clustering after computing Canopies)</br>\r\r\n -xm (execution method: sequential or mapreduce)</br>', '$MAHOUT_HOME/bin/mahout org.apache.mahout.clustering.syntheticcontrol.kmeans.Job\r\n', 'zhonghua', '2016-12-30 15:22:04', '1', '聚类算法', 'syntheticcontrol.kmeans');
INSERT INTO `algorithm` VALUES ('2', 'Fuzzy K-Means', '一种模糊聚类算法，是k均值聚类算法的推广形式，隶属度取值为[0 1]区间内的任何一个数，提出的基本根据是“类内加权误差平方和最小化”准则。', null, null, 'zhonghua', '2016-12-30 15:22:04', '1', '聚类算法', 'syntheticcontrol.fuzzykmeans');
INSERT INTO `algorithm` VALUES ('3', 'Canopy', 'Canopy算法是基于Kmeans算法的一种优化的聚类方法。优化体现在:\r\n 1.前期能通过一些低性能的算法，快速的获取聚类中心\r\n 2.分好的每个聚类内部在进行k-means计算（不同聚类之间不进行相似度计算）', null, null, 'zhonghua', '2016-12-30 15:22:04', '1', '聚类算法', 'syntheticcontrol.canopy');
INSERT INTO `algorithm` VALUES ('4', 'EM', 'EM算法就是假设我们想估计知道A和B两个参数，在开始状态下二者都是未知的，但如果知道了A的信息就可以得到B的信息，反过来知道了B也就得到了A。可以考虑首先赋予A某种初值，以此得到B的估计值，然后从B的当前值出发，重新估计A的取值，这个过程一直持续到收敛为止。', null, null, 'zhonghua', '2016-12-30 15:22:04', '1', '聚类算法', null);
INSERT INTO `algorithm` VALUES ('5', 'Dirichlet Process', 'Dirichlet clustering 一种基于贝叶斯分类的聚类算法  不只是给出一种聚类结果，而是给出多种聚类方案，一般在其他聚类算法之前运行，聚类结果可以帮我们理解数据并选择更好的聚类算法门限聚类方式(overlap或者分层)和距离度量方式', null, null, 'zhonghua', '2016-12-30 15:22:04', '1', '聚类算法', null);
INSERT INTO `algorithm` VALUES ('6', 'Naive Bayes', '朴素贝叶斯分类是一种十分简单的分类算法，叫它朴素贝叶斯分类是因为这种方法的思想真的很朴素，朴素贝叶斯的思想基础是这样的：对于给出的待分类项，求解在此项出现的条件下各个类别出现的概率，哪个最大，就认为此待分类项属于哪个类别。', null, null, 'Nancy', '2016-12-30 15:22:04', '2', '分类算法', null);
INSERT INTO `algorithm` VALUES ('7', 'KNN', 'kNN算法的核心思想是如果一个样本在特征空间中的k个最相邻的样本中的大多数属于某一个类别，则该样本也属于这个类别，并具有这个类别上样本的特性。该方法在确定分类决策上只依据最邻近的一个或者几个样本的类别来决定待分样本所属的类别。 kNN方法在类别决策时，只与极少量的相邻样本有关。由于kNN方法主要靠周围有限的邻近的样本，而不是靠判别类域的方法来确定所属类别的，因此对于类域的交叉或重叠较多的待分样本集来说，kNN方法较其他方法更为适合。', null, null, 'Nancy', '2016-12-30 15:22:04', '2', '分类算法', null);
INSERT INTO `algorithm` VALUES ('8', 'SVM', 'SVM的主要思想可以概括为两点：⑴它是针对线性可分情况进行分析，对于线性不可分的情况，通过使用非线性映射算法将低维输入空间线性不可分的样本转化为高维特征空间使其线性可分，从而 使得高维特征空间采用线性算法对样本的非线性特征进行线性分析成为可能。', null, null, 'Nancy', '2016-12-30 15:22:04', '2', '分类算法', null);
INSERT INTO `algorithm` VALUES ('9', 'Logistic Regression', '逻辑回归或罗吉斯回归（英语：Logistic regression 或logit regression），即逻辑模型（英语：Logit model，也译作“评定模型”、“分类评定模型”）是离散选择法模型之一，属于多重变量分析范畴，是社会学、生物统计学、临床、数量心理学、计量经济学、市场营销等统计实证分析的常用方法。', null, null, '赵雷', '2016-12-30 15:22:04', '2', '分类算法', null);
INSERT INTO `algorithm` VALUES ('10', 'Neural Network', '神经网络分类算法的重点是构造阈值逻辑单元，一个值逻辑单元是一个对象，它可以输入一组加权系数的量，对它们进行求和，如果这个和达到或者超过了某个阈值，输出一个量。如有输入值X1, X2, ..., Xn 和它们的权系数：W1, W2, ..., Wn，求和计算出的 Xi*Wi ，产生了激发层 a = (X1 * W1)+(X2 * W2)+...+(Xi * Wi)+...+ (Xn * Wn)，其中Xi 是各条记录出现频率或其他参数，Wi是实时特征评估模型中得到的权系数。神经网络是基于经验风险最小化原则的学习算法，有一些固有的缺陷，比如层数和神经元个数难以确定，容易陷入局部极小，还有过学习现象，这些本身的缺陷在SVM算法中可以得到很好的解决。', null, null, '赵雷', '2016-12-30 15:22:04', '2', '分类算法', null);
INSERT INTO `algorithm` VALUES ('11', 'SVD', '奇异值分解（singular value decomposition）是线性代数中一种重要的矩阵分解，在信号处理、统计学等领域有重要应用。奇异值分解在某些方面与对称矩阵或Hermitian矩阵基于特征向量的对角化类似。然而这两种矩阵分解尽管有其相关性，但还是有明显的不同。对称阵特征向量分解的基础是谱分析，而奇异值分解则是谱分析理论在任意矩阵上的推广。', null, null, '赵雷', '2016-12-30 15:22:04', '3', '降维算法', null);
INSERT INTO `algorithm` VALUES ('12', 'PCA', 'Principal Component Analysis(PCA)是最常用的线性降维方法，它的目标是通过某种线性投影，将高维的数据映射到低维的空间中表示，并期望在所投影的维度上数据的方差最大，以此使用较少的数据维度，同时保留住较多的原数据点的特性。', null, null, 'Jack Ma', '2016-12-30 15:22:04', '3', '降维算法', null);
INSERT INTO `algorithm` VALUES ('13', 'ICA', '独立成分分析(Independent Component Analysis，ICA)是近年来提出的非常有效的数据分析工具，它主要用来从混合数据中提取出原始的独立信号。它作为信号分离的一种有效方法而受到广泛的关注。', null, null, 'Jack Ma', '2016-12-30 15:22:04', '3', '降维算法', null);
INSERT INTO `algorithm` VALUES ('14', 'LDA', '潜在狄里克雷分布(Latent Dirichlet Allocation) 可以用来识别大规模文档集（document collection）或语料库（corpus）中潜藏的主题信息。它采用了词袋（bag of words）的方法，这种方法将每一篇文档视为一个词频向量，从而将文本信息转化为了易于建模的数字信息。但是词袋方法没有考虑词与词之间的顺序，这简化了问题的复杂性，同时也为模型的改进提供了契机。每一篇文档代表了一些主题所构成的一个概率分布，而每一个主题又代表了很多单词所构成的一个概率分布。', null, null, 'James', '2016-12-30 15:22:04', '4', '主题模型', null);
INSERT INTO `algorithm` VALUES ('15', 'User-Based Collaborative Filtering', 'User-Based Collaborative Filtering 基于用户对物品的偏好找到相邻邻居用户，然后将邻居用户喜欢的推荐给当前用户。计算上，就是将一个用户对所有物品的偏好作为一个向量来计算用户之间的相似度，找到 K 邻居后，根据邻居的相似度权重以及他们对物品的偏好，预测当前用户没有偏好的未涉及物品，计算得到一个排序的物品列表作为推荐。', null, null, 'AI', '2016-12-30 15:22:04', '5', '协同过滤', null);

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `class_describe` text,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '聚类算法', '聚类分析又称群分析，它是研究（样品或指标）分类问题的一种统计分析方法，同时也是数据挖掘的一个重要算法。');
INSERT INTO `class` VALUES ('2', '分类算法', '分类(Categorization or Classification)就是按照某种标准给对象贴标签(label)，再根据标签来区分归类。分类是事先定义好类别，类别数不变。分类器需要由人工标注的分类训练语料训练得到，属于有指导学习范畴');
INSERT INTO `class` VALUES ('3', '降维算法', '数据降维基本原理是将样本点从输入空间通过线性或非线性变换映射到一个低维空间，从而获得一个关于原数据集紧致的低维表示。');
INSERT INTO `class` VALUES ('4', '主题模型', '在机器学习和自然语言处理等领域是用来在一系列文档中发现抽象主题的一种统计模型。 直观来讲，如果一篇文章有一个中心思想，那么一些特定词语会更频繁的出现。');
INSERT INTO `class` VALUES ('5', '协同过滤', '在信息过滤和信息系统中正迅速成为一项很受欢迎的技术。与传统的基于内容过滤直接分析内容进行推荐不同，协同过滤分析用户兴趣，在用户群中找到指定用户的相似（兴趣）用户，综合这些相似用户对某一信息的评价，形成系统对该指定用户对此信息的喜好程度预测。');

-- ----------------------------
-- Table structure for cluster
-- ----------------------------
DROP TABLE IF EXISTS `cluster`;
CREATE TABLE `cluster` (
  `cluster_id` int(11) NOT NULL,
  `cluster_name` varchar(255) DEFAULT NULL,
  `cluster_node_number` int(11) DEFAULT NULL,
  `cluster_master_number` int(11) DEFAULT NULL,
  `cluster_slave_number` int(11) DEFAULT NULL,
  `cluster_storage_number` int(11) DEFAULT NULL,
  `cluster_cpu_number` int(11) DEFAULT NULL,
  `cluster_cpu_kernel_number` int(11) DEFAULT NULL,
  `cluster_total_storage` varchar(255) DEFAULT NULL,
  `cluster_total_momery` varchar(255) DEFAULT NULL,
  `cluster_os` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cluster_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cluster
-- ----------------------------
INSERT INTO `cluster` VALUES ('1', 'Hadoop集群', '9', '1', '7', '1', '10', '64', '5T', '128G', 'Ubuntu');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `file_id` int(11) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `file_discribe` varchar(255) DEFAULT NULL,
  `file_directory` varchar(255) DEFAULT NULL,
  `file_complete_path` varchar(255) DEFAULT NULL,
  `file_relative_path` varchar(255) DEFAULT NULL,
  `file_author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL,
  `message_content` varchar(255) DEFAULT NULL,
  `message_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node` (
  `node_id` int(11) NOT NULL AUTO_INCREMENT,
  `node_name` varchar(255) DEFAULT NULL,
  `node_status` varchar(255) DEFAULT NULL,
  `node_ip` varchar(255) DEFAULT NULL,
  `node_specification` varchar(255) DEFAULT NULL,
  `node_role` varchar(255) DEFAULT NULL,
  `node_creater` varchar(255) DEFAULT NULL,
  `node_time` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES ('1', 'Hadoop_master', '运行中', '192.168.1.99', '8核32G', '主节点', 'zhonghua', '2016-12-30 17:03:32', 'master');
INSERT INTO `node` VALUES ('2', 'Hadoop_storage', '运行中', '192.168.1.110', '16核64G', '存储节点', 'zhonghua', '2016-12-30 17:03:32', null);
INSERT INTO `node` VALUES ('3', 'Hadoop_slave1', '运行中', '192.168.1.101', '8核4G', '子节点', 'zhonghua', '2016-12-30 17:03:32', null);
INSERT INTO `node` VALUES ('4', 'Hadoop_slave2', '运行中', '192.168.1.102', '8核4G', '子节点', 'zhonghua', '2016-12-30 17:03:32', null);
INSERT INTO `node` VALUES ('5', 'Hadoop_slave3', '运行中', '192.168.1.103', '8核4G', '子节点', 'zhonghua', '2016-12-30 17:03:32', null);
INSERT INTO `node` VALUES ('6', 'Hadoop_slave4', '运行中', '192.168.1.104', '8核4G', '子节点', 'zhonghua', '2016-12-30 17:03:32', null);
INSERT INTO `node` VALUES ('7', 'Hadoop_slave5', '运行中', '192.168.1.105', '8核4G', '子节点', 'zhonghua', '2016-12-30 17:03:32', null);
INSERT INTO `node` VALUES ('8', 'Hadoop_slave6', '运行中', '192.168.1.106', '8核4G', '子节点', 'zhonghua', '2016-12-30 17:03:32', null);
INSERT INTO `node` VALUES ('9', 'Hadoop_slave7', '运行中', '192.168.1.107', '8核4G', '子节点', 'zhonghua', '2016-12-30 17:03:32', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_realname` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_city` varchar(255) DEFAULT NULL,
  `user_country` varchar(255) DEFAULT NULL,
  `user_authority` int(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- View structure for class_count
-- ----------------------------
DROP VIEW IF EXISTS `class_count`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `class_count` AS (select `class`.`class_id` AS `class_id`,`class`.`class_name` AS `class_name`,`class`.`class_describe` AS `class_describe`,count(`algorithm`.`algorithm_id`) AS `class_number` from (`class` left join `algorithm` on((`class`.`class_id` = `algorithm`.`class_id`))) group by `class`.`class_id` order by `class`.`class_id`) ;

-- ----------------------------
-- View structure for rank_month
-- ----------------------------
DROP VIEW IF EXISTS `rank_month`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `rank_month` AS (select `algorithm`.`algorithm_author` AS `algorithm_author`,count(0) AS `submit_num` from `algorithm` where ((curdate() - interval 1 month) <= cast(`algorithm`.`algorithm_time` as date)) group by `algorithm`.`algorithm_author` order by `submit_num` desc) ;

-- ----------------------------
-- View structure for rank_year
-- ----------------------------
DROP VIEW IF EXISTS `rank_year`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `rank_year` AS (select `algorithm`.`algorithm_author` AS `algorithm_author`,count(0) AS `submit_num` from `algorithm` where ((curdate() - interval 1 year) <= cast(`algorithm`.`algorithm_time` as date)) group by `algorithm`.`algorithm_author` order by `submit_num` desc) ;
