union-find 算法实现

## 描述用来解决各个点是否联通的问题,实际工作中可用作物理机的网络联通问题查找

#### 1.con.mloine.ch1.unionfind.AbstractUF 定义了基础API

#### 2.con.mloine.ch1.unionfind.QuickFindUF 实现了快速find的算法 但union操作的效率在大数据量下不可接受

#### 3.con.mloine.ch1.unionfind.QuickUnionUF 实现了快速union算法 同时find操作也在线性级别。 但union极端情况下也会出现平方级别的效率

#### 4.con.mloine.ch1.unionfind.WeightQuickUnionUF 对quickUnion的改进 保证小树连接到大树上 避免深度过深 可以带到对数级别操作。可用于大数据体量

#### 5.con.mloine.ch1.unionfind.ZipWeightQuickUnionUF 对 WeightQuickUnionUF 改进 find时会减少过深节点的深度 进一步优化

