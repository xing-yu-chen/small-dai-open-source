<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>小呆 - ${dao.comment}管理</title>
    <link rel="stylesheet" href="./assets/css/login.css">
    <script src="./assets/js/vue.global.js"></script>
    <!-- import CSS -->
    <link rel="stylesheet" href="./assets/css/index.css">
    <!-- import ElementPlus JavaScript -->
    <script src="./assets/js/index.full.js"></script>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        #${dao.dealingTableName?uncap_first}Manager {
            width: 100%;
            height: 100vh;
        }

        .black-el-header{
            background-color: black;
            height: 8.5vh;
            color: var(--el-text-color-primary);
            text-align: center;
            line-height: 8.5vh;
            color: white;
        }

        .el-aside {
            background-color: black;
            color: var(--el-text-color-primary);
            text-align: center;
        }

        .el-main,
        .el-footer {
            background-color: #e9eef3;
            color: var(--el-text-color-primary);
            text-align: center;
        }
    </style>
</head>
<body>
<div id="${dao.dealingTableName?uncap_first}Manager">
    <el-container style="width:100%;height: 100%;">
        <el-header class="black-el-header">
            <el-row>
                <el-col :span="3">
                    小呆生成器
                </el-col>
                <el-col :span="2" :offset="19">
                    <el-dropdown>
                        <span v-if="userDao != null && userDao != undefined">{{userDao.uName}}</span>
                        <span v-if="userDao == null || userDao == undefined">小呆</span>
                        <template #dropdown>
                            <el-dropdown-menu>
                                <el-dropdown-item>个人信息</el-dropdown-item>
                                <el-dropdown-item>GitHub</el-dropdown-item>
                                <el-dropdown-item>退出</el-dropdown-item>
                            </el-dropdown-menu>
                        </template>
                    </el-dropdown>
                </el-col>
            </el-row>
        </el-header>
        <el-container style="width: 100%;height: 90vh;">
            <el-aside width="15%">
                <el-menu active-text-color="#ffd04b" background-color="black" class="el-menu-vertical-demo"
                         text-color="#fff">
                    <el-menu-item index="1">
                        <span  style="display: inline-block;width: 100%;height: 100%;text-align: center"><a style="display: inline-block;width: 100%;height: 100%;color: white" href="./panel.html" style="color: white;">数据面板</a></span>
                    </el-menu-item>
                    <#assign n=1>
                    <#list daoList as list><#assign n++>
                    <el-menu-item index="${n}">
                        <span style="display: inline-block;width: 100%;height: 100%;text-align: center"><a style="display: inline-block;width: 100%;height: 100%;color: white" href="./${list.dealingTableName?uncap_first}Manager.html" style="color: white;">${list.comment}管理</a></span>
                    </el-menu-item>
                    </#list>
                </el-menu>
            </el-aside>
            <el-container>
                <el-main>
                    <h2>${dao.comment}管理</h2>
                    <el-row>
                        <el-col :span="2">
                            <el-button type="info" plain @click="flush">
                                <el-icon>
                                    <svg class="icon" width="200" height="200" viewBox="0 0 1024 1024"
                                         xmlns="http://www.w3.org/2000/svg" data-v-365b8594="">
                                        <path fill="currentColor"
                                              d="M771.776 794.88A384 384 0 01128 512h64a320 320 0 00555.712 216.448H654.72a32 32 0 110-64h149.056a32 32 0 0132 32v148.928a32 32 0 11-64 0v-50.56zM276.288 295.616h92.992a32 32 0 010 64H220.16a32 32 0 01-32-32V178.56a32 32 0 0164 0v50.56A384 384 0 01896.128 512h-64a320 320 0 00-555.776-216.384z">
                                        </path>
                                    </svg>
                                </el-icon>
                                刷新
                            </el-button>
                        </el-col>
                        <el-col :span="3">
                            <el-popconfirm title="确认是否删除所有选中条数" icon-color="red"  @confirm="sureDeleteAll" @cancel="cancelDeleteAll" v-if="clear1">
                                <template #reference>
                                    <el-button type="danger" plain>
                                        <el-icon>
                                            <svg class="icon" width="200" height="200" viewBox="0 0 1024 1024"
                                                 xmlns="http://www.w3.org/2000/svg" data-v-365b8594="">
                                                <path fill="currentColor"
                                                      d="M160 256H96a32 32 0 010-64h256V95.936a32 32 0 0132-32h256a32 32 0 0132 32V192h256a32 32 0 110 64h-64v672a32 32 0 01-32 32H192a32 32 0 01-32-32V256zm448-64v-64H416v64h192zM224 896h576V256H224v640zm192-128a32 32 0 01-32-32V416a32 32 0 0164 0v320a32 32 0 01-32 32zm192 0a32 32 0 01-32-32V416a32 32 0 0164 0v320a32 32 0 01-32 32z">
                                                </path>
                                            </svg>
                                        </el-icon>
                                        批量删除
                                    </el-button>
                                </template>
                            </el-popconfirm>
                        </el-col>
                        <el-col :span="2">
                            <el-button type="primary" plain @click="clickInsert" v-if="save1">
                                <el-icon>
                                    <svg class="icon" width="200" height="200" viewBox="0 0 1024 1024"
                                         xmlns="http://www.w3.org/2000/svg" data-v-365b8594="">
                                        <path fill="currentColor"
                                              d="M480 480V128a32 32 0 0164 0v352h352a32 32 0 110 64H544v352a32 32 0 11-64 0V544H128a32 32 0 010-64h352z">
                                        </path>
                                    </svg>
                                </el-icon>
                                新增
                            </el-button>
                        </el-col>
                        <el-col :span="4" :offset="8">
                            <el-input v-model="input" placeholder="输入筛选信息" clearable />
                        </el-col>
                        <el-col :span="1">
                            <el-button type="primary">
                                <el-icon>
                                    <svg class="icon" width="200" height="200" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-365b8594=""><path fill="currentColor" d="M795.904 750.72l124.992 124.928a32 32 0 01-45.248 45.248L750.656 795.904a416 416 0 1145.248-45.248zM480 832a352 352 0 100-704 352 352 0 000 704z"></path></svg>
                                </el-icon>
                            </el-button>
                        </el-col>
                    </el-row>
                    <br>

                    <el-table :data="tableData.records" @selection-change="handleSelectionChange" >
                        <el-table-column type="selection" width="55"></el-table-column>
                        <#list dao.columns as column>
                            <el-table-column prop="${column.dealingColumnName?uncap_first}" label="${column.columnComment}"></el-table-column>
                        </#list>

                        <el-table-column fixed="right" label="操作" width="120">
                            <template #default="scope">
                                <el-button type="primary" circle  @click.prevent="updateRow(scope.$index, scope.row)" v-if="update1">
                                    <el-icon>
                                        <svg class="icon" width="200" height="200" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-365b8594=""><path fill="currentColor" d="M832 512a32 32 0 1164 0v352a32 32 0 01-32 32H160a32 32 0 01-32-32V160a32 32 0 0132-32h352a32 32 0 010 64H192v640h640V512z"></path><path fill="currentColor" d="M469.952 554.24l52.8-7.552L847.104 222.4a32 32 0 10-45.248-45.248L477.44 501.44l-7.552 52.8zm422.4-422.4a96 96 0 010 135.808l-331.84 331.84a32 32 0 01-18.112 9.088L436.8 623.68a32 32 0 01-36.224-36.224l15.104-105.6a32 32 0 019.024-18.112l331.904-331.84a96 96 0 01135.744 0z"></path></svg>
                                    </el-icon>
                                </el-button>
                                <el-popconfirm title="你确定要删除这行吗?" @confirm="sureDelete" v-if="delete1">
                                    <template #reference>
                                        <el-button type="danger" circle  @click.prevent="deleteRow(scope.$index, scope.row)" >
                                            <el-icon>
                                                <svg class="icon" width="200" height="200" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-365b8594=""><path fill="currentColor" d="M160 256H96a32 32 0 010-64h256V95.936a32 32 0 0132-32h256a32 32 0 0132 32V192h256a32 32 0 110 64h-64v672a32 32 0 01-32 32H192a32 32 0 01-32-32V256zm448-64v-64H416v64h192zM224 896h576V256H224v640zm192-128a32 32 0 01-32-32V416a32 32 0 0164 0v320a32 32 0 01-32 32zm192 0a32 32 0 01-32-32V416a32 32 0 0164 0v320a32 32 0 01-32 32z"></path></svg>
                                            </el-icon>
                                        </el-button>
                                    </template>
                                </el-popconfirm>
                            </template>
                        </el-table-column>
                    </el-table>

                    <el-pagination layout="prev, pager, next, jumper"  :page-count="tableData.pages" :current-page="currentPage"  :total="tableData.total" @current-change="handleCurrentChange"></el-pagination>

                </el-main>
                <el-footer style="height: 3vh;">
                    Copyright © 2021 <a
                        href="https://github.com/xing-yu-chen/small-dai-open-source">small-dai-open-source</a>.
                    All rights reserved.
                </el-footer>
            </el-container>
        </el-container>
    </el-container>
    <!--新增数据-->
    <el-dialog
            v-model="insertVisible"
            title="新增数据"
            width="50%"
            :before-close="handleClose"
            v-if="save1"
    >
        <el-form :model="insert${dao.dealingTableName?cap_first}Array" :rules="rules" label-width="120px">
            <#list dao.columns as column>
            <#if column.columnKey == false>
                <#if column.columnComment != "创建时间" && column.columnComment != "修改时间" && column.dealingColumnName?uncap_first != "deleted">
                    <el-form-item label="${column.columnComment}" prop="${column.dealingColumnName?uncap_first}">
                        <el-input v-model="insert${dao.dealingTableName?cap_first}Array.${column.dealingColumnName?uncap_first}"></el-input>
                    </el-form-item>
                </#if>
            </#if>
            </#list>
        </el-form>
        <template #footer>
			      <span class="dialog-footer">
			        <el-button @click="insertVisible = false">取消</el-button>
			        <el-button type="primary" @click="sureInsert"
                    >新增</el-button>
			      </span>
        </template>
    </el-dialog>

    <!--修改数据-->
    <el-dialog
            v-model="updateVisible"
            title="修改数据"
            width="50%"
            :before-close="handleClose"
            v-if="update1"
    >
        <el-form :model="update${dao.dealingTableName?cap_first}Array" :rules="rules" label-width="120px">
        <#list dao.columns as column>
            <#if column.columnKey == false>
            <#if column.columnComment != "创建时间" && column.columnComment != "修改时间" >
            <el-form-item label="${column.columnComment}" prop="${column.dealingColumnName?uncap_first}">
                <el-input v-model="update${dao.dealingTableName?cap_first}Array.${column.dealingColumnName?uncap_first}"></el-input>
            </el-form-item>
            </#if>
            </#if>
        </#list>
        </el-form>
        <template #footer>
			        <span class="dialog-footer">
			          <el-button @click="updateVisible = false">取消</el-button>
			          <el-button type="primary" @click="sureUpdate"
                      >修改</el-button>
			        </span>
        </template>
    </el-dialog>
</div>
</body>
<script src="./assets/js/axios.min.js"></script>
<script>
    const {
        createApp
    } = Vue;

    //基础路径
    var baseUrl = "http://localhost/v1";

    const app = createApp({
        data(){
            return {
                userDao: JSON.parse(window.localStorage.getItem("userMsg")),
                tableData: [],
                deleteArray: [],
                visited1: false,
                save1: false,
                delete1: false,
                update1: false,
                clear1: false,
                delete${dao.dealingTableName?cap_first}Id: 0,
                userArray: [],
                currentPage: sessionStorage.getItem("${dao.dealingTableName?uncap_first}ManagerPageNumber"),
                insertVisible: false,
                updateVisible: false,
                insert${dao.dealingTableName?cap_first}Array: {
                    name: '',
                    uPassword: '',
                    uEmail: '',
                    uTelephone: '',
                    uAge: '',
                    uAddress: ''
                },
                update${dao.dealingTableName?cap_first}Array: {},
                rules: {
                <#list dao.columns as column>
                    <#if column.columnKey == false>
                    <#if column.columnComment != "创建时间" && column.columnComment != "修改时间" && column.dealingColumnName?uncap_first != "deleted">
                    ${column.dealingColumnName?uncap_first}: [
                        {required: true, message: '请输入${column.columnComment}', trigger: 'blur' }
                    ],
                    </#if>
                    </#if>
                </#list>
                }
            }
        },
        methods: {
            //获取分页list数据
            list(num){
                axios.get( baseUrl + "/${dao.dealingTableName?uncap_first}s/"+num+"/page").then(res=>{
                    sessionStorage.setItem("${dao.dealingTableName?uncap_first}ManagerPageNumber",num)
                    this.tableData = res.data.data
                })
            },
            //分页点击处理
            handleCurrentChange(val){
                //获取新页面的表单元素
                this.list(val)
                //改变当前页为此页
                this.currentPage = val
            },
            //模块所有权限
            getAllModule(){
                axios.get( baseUrl + "/permissions/${dao.dealingTableName?cap_first}/module").then(res=>{
                    var permissionByRole = JSON.parse(localStorage.getItem("permissionsByRole"))
                    for (var i = 0; i < res.data.data.length; i++) {
                        for (var j = 0; j < permissionByRole.length; j++) {
                            if(permissionByRole[j].pId == res.data.data[i].pId){
                                if(res.data.data[i].pName.indexOf("visited") != -1){
                                    this.visited1 = true
                                }else if(res.data.data[i].pName.indexOf("save") != -1){
                                    this.save1 = true
                                }else if(res.data.data[i].pName.indexOf("delete") != -1){
                                    this.delete1 = true
                                }else if(res.data.data[i].pName.indexOf("update") != -1){
                                    this.update1 = true
                                }else if(res.data.data[i].pName.indexOf("clear") != -1){
                                    this.clear1 = true
                                }
                            }
                        }
                    }
                }).catch((err)=>{
                    this.$message.error("权限获取失败")
                    console.log(err)
                })
            },
            //批量删除请求
            deleteAll(){
                axios.delete( baseUrl + "/${dao.dealingTableName?uncap_first}s", {data: this.${dao.dealingTableName?uncap_first}Array} ).then(res=>{
                    if(res.data.code == 200){
                        sessionStorage.setItem("${dao.dealingTableName?uncap_first}ManagerPageNumber",1)
                        this.list(1)
                    }else{
                        this.$message('操作失误')
                    }
                }).catch(() =>{
                    console.log("操作异常")
                })
            },
            //确认批量删除
            sureDeleteAll(){
                //通过请求进行批量删除
                this.deleteAll()
            },
            //取消批量删除
            cancelDeleteAll(){
                this.${dao.dealingTableName?uncap_first}Array = []
            },
            //勾选一键清除的条目
            handleSelectionChange(val){
                this.${dao.dealingTableName?uncap_first}Array = val
            },
            //显示新增对话框
            clickInsert(){
                this.insertVisible = !this.insertVisible
            },
            //新增用户请求
            sureInsert(){
                axios.post( baseUrl + "/${dao.dealingTableName?uncap_first}s", this.insert${dao.dealingTableName?cap_first}Array).then(res=>{
                    if(res.data.code == 200){
                        this.$message.success(res.data.msg)
                    }else{
                        this.$message.error(res.data.data)
                    }
                    let ${dao.dealingTableName?uncap_first}ManagerPageNumber = sessionStorage.getItem("${dao.dealingTableName?uncap_first}ManagerPageNumber")
                    if (${dao.dealingTableName?uncap_first}ManagerPageNumber!==null && ${dao.dealingTableName?uncap_first}ManagerPageNumber !== undefined){
                        //初始化加载缓存的那一页
                        this.list(${dao.dealingTableName?uncap_first}ManagerPageNumber)
                    }else{
                        //初始化第一页
                        this.list(1)
                    }
                    this.insertVisible = false
                }).catch(()=>{
                    console.log("操作异常")
                })
            },
            //修改行
            updateRow(index,row){
                this.updateVisible = !this.updateVisible
                this.update${dao.dealingTableName?cap_first}Array = row
            },
            //确认修改数据请求
            sureUpdate(){
                axios.put( baseUrl + "/${dao.dealingTableName?uncap_first}s", this.update${dao.dealingTableName?cap_first}Array ).then(res=>{
                    if(res.data.code == 200 ){
                        this.$message.success(res.data.data)
                    }else {
                        this.$message.error(res.data.data)
                    }
                    this.updateVisible = !this.updateVisible
                    this.list(sessionStorage.getItem("${dao.dealingTableName?uncap_first}ManagerPageNumber"))
                }).catch(()=>{
                    console.log("操作异常")
                })
            },
            //单独删除行
            deleteRow(index, row){
                this.delete${dao.dealingTableName?cap_first}Id = row.uId
            },
            //确认删除行
            sureDelete(){
                //此处传入uId
                axios.delete( baseUrl + "/${dao.dealingTableName?uncap_first}s/" + this.delete${dao.dealingTableName?cap_first}Id ).then(res=>{
                    if(res.data.code == 200){
                        sessionStorage.setItem("${dao.dealingTableName?uncap_first}ManagerPageNumber", 1)
                        this.list(1)
                    }else{
                        this.$message('操作失误')
                    }
                })
            },
            //初始化页面
            load(){
                let ${dao.dealingTableName?uncap_first}ManagerPageNumber = sessionStorage.getItem("${dao.dealingTableName?uncap_first}ManagerPageNumber")
                if(${dao.dealingTableName?uncap_first}ManagerPageNumber!==null && ${dao.dealingTableName?uncap_first}ManagerPageNumber !== undefined){
                    //初始化加载缓存的那一页
                    this.list(${dao.dealingTableName?uncap_first}ManagerPageNumber)
                }else{
                    //初始化第一页
                    this.list(1)
                }
            },
            //刷新页面
            flush(){
                window.location.reload();
            }
        },
        mounted(){
            this.load()
            this.getAllModule()
        }
    })
    app.use(ElementPlus)
    app.mount("#${dao.dealingTableName?uncap_first}Manager")
</script>
</html>
