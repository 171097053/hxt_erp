//获取当前用户id
var userId = sessionStorage.getItem("userId");
requesTitle = new Array();

/**
 * 初始化列
 */
function initColums() {
    columns = new Array();
    /* $.ajax({
         type: "get",
         url: "/column/getcolumn",
         dataType: "json",
         success: function (column) {
        cols = {field: 'id', width: 35, align: "center", checkbox: true}
                /!* {
                     title: '操作', field: 'op', align: "center", width: 60,
                     formatter: function (value, rec, index) {
                         var str = '';
                         str += '<img title="编辑" src="/js/easyui/themes/icons/pencil.png" style="cursor: pointer;" onclick="editMaterial(\'' + index + '\');"/>';
                         if (isShowOpFun()) {
                             str += '<img title="删除" src="/js/easyui/themes/icons/edit_remove.png" style="cursor: pointer;" onclick="deleteMaterial(' + rec.id + ');"/>';
                         }
                         return str;
                     }
                 },
                 {title: '品名', field: 'name', width: 150, align: "center"},
                 {
                     title: '图片', field: 'image', width: 60, height: 50, align: "center",
                     //格式化并返回img标签
                     formatter: function (value, row, index) {
                         //return "<img style='width:72px;height:72px;' border='1' src='" + value + "'/>";
                         return "<img style='width:50px;height:50px;' src='" + value + "' onmouseover='bigImg(this," + index + ")' onmouseout='closeImg()'/>";
                     }
                 }*!/

             columns.push(cols);
             // for (var i = 0; i < column.length; i++) {
             //
             //     var cols2 = {
             //         title: column[i].title,
             //         field: column[i].field,
             //         width: parseInt(column[i].width),
             //         align: column[i].align,
             //         hidden: column[i].hidden
             //     };
             //     columns.push(cols2);
             // }


         }


     });*/
    $.getJSON('/column/getcolumn', function (column) {
        cols = {field: 'id', width: 35, align: "center", checkbox: true, height: 50};
        cols2 = {
            title: '操作', field: 'op', align: "center", width: 60, height: 50,
            formatter: function (value, rec, index) {
                var str = '';
                str += '<img title="编辑" src="/js/easyui/themes/icons/pencil.png" style="cursor: pointer;" onclick="editMaterial(\'' + index + '\');"/>';
                if (isShowOpFun()) {
                    str += '<img title="删除" src="/js/easyui/themes/icons/edit_remove.png" style="cursor: pointer;" onclick="deleteMaterial(' + rec.id + ');"/>';
                }
                return str;
            }
        };
        columns.push(cols);
        columns.push(cols2);
        //获取当前用户拥有的列
        var userColumns = localStorage.getItem(userId);
        var strings;
        //显示拥有的列
        if (userColumns != null) {
            strings = userColumns.split(",")
            cols3 = {title: '品名', field: 'name', width: 150, align: "center", height: 50, hidden: strings[i] == 0 ? true : false};
            cols4 = {
                title: '图片', field: 'image', width: 60, height: 50, align: "center", hidden: strings[i] == 0 ? true : false,
                //格式化并返回img标签
                formatter: function (value, row, index) {
                    //return "<img style='width:72px;height:72px;' border='1' src='" + value + "'/>";
                    return "<img style='width:50px;height:50px;' src='" + value + "' onmouseover='bigImg(this," + index + ")' onmouseout='closeImg()'/>";
                }
            };
            columns.push(cols3);
            columns.push(cols4);
            for (var i = 0; i < column.length; i++) {

                colss = {
                    title: column[i].title,
                    field: column[i].field,
                    width: parseInt(column[i].width),
                    align: column[i].align,
                    hidden: strings[i+2] == 0 ? true : false,
                };

                columns.push(colss);
            }

        }
        //没有默认隐藏所有列
        if (userColumns == null) {
            cols3 = {title: '品名', field: 'name', width: 150, align: "center", height: 50, hidden:true};
            cols4 = {
                title: '图片', field: 'image', width: 60, height: 50, align: "center", hidden: true,
                //格式化并返回img标签
                formatter: function (value, row, index) {
                    //return "<img style='width:72px;height:72px;' border='1' src='" + value + "'/>";
                    return "<img style='width:50px;height:50px;' src='" + value + "' onmouseover='bigImg(this," + index + ")' onmouseout='closeImg()'/>";
                }
            };
            columns.push(cols3);
            columns.push(cols4);
            for (var i = 0; i < column.length; i++) {
                colss = {
                    title: column[i].title,
                    field: column[i].field,
                    width: parseInt(column[i].width),
                    align: column[i].align,
                    hidden: true
                };
                columns.push(colss);
            }

        }
        //初始化列表
        initTableData(columns);
        //初始化分页
        ininPager();

    })
}

//初始化datarid网格大小
function dgResize() {
    var searchTabHeight = $('.box-body').height();
    if ($('#tableData') && $('#tableData').length && $('#tableData').datagrid()) {
        $('#tableData').datagrid('resize', {
            width: $(window).width() - 13,
            height: $(window).height() - searchTabHeight - 51
        });

    }
}

//动态改变网格大小
$(window).resize(function () {
    dgResize()
    //刷新数据
    initTableData(columns)
    ininPager()
});

/**
 * 设置显示列
 */
function chooseColumShow() {
    var title = '设置列显示页面';
    var custsList = $('#tableData');
    initShowColumnWindow($('#show_column_window'), $('#show_column_datalist'), custsList, title);
}
function chooseExcel() {
    var title = '自定义Excel模板';
    var custsList = $('#tableData');
    initShowColumnWindow2($('#show_column_excel_window'), $('#show_column_excel_datalist'), custsList, title);
}

var dialog_showColumn;//设置显示列弹出框
var datalist_column;//设置显示列datalist
var datagrid;//具体操作的datagrid


/**
 * 设置列显示、隐藏
 * @param {} dialog_showColumnWindow
 * @param {} datalist_columnShow
 * @param {} dg
 * @param {} title
 */
function initShowColumnWindow(dialog_showColumnWindow, datalist_columnShow, dg, title) {
    dialog_showColumn = dialog_showColumnWindow;
    datalist_column = datalist_columnShow;
    datagrid = dg;
    dialog_showColumnWindow.dialog({
        title: title,
        closable: true,
        collapsible: false,
        maximizable: false,
        minimizable: false,
        resizable: true,
        draggable: true,
        modal: true,
        width: 240,
        height: 400,
        onOpen: function () {
            var columnFields = dg.datagrid("getColumnFields");
            var columnDefineArray = [];
            var checkedRow = [];
            $.each(columnFields, function (i, columnField) {
                var fieldOptions = dg.datagrid("getColumnOption", columnField);
                fieldOptions.text = fieldOptions.title;
                fieldOptions.value = columnField;
                if (!fieldOptions.hidden) {
                    checkedRow.push(i);
                }
                columnDefineArray.push(fieldOptions);
            });
            datalist_columnShow.datalist({
                lines: true,
                checkbox: true,
                selectOnCheck: false,
                singleSelect: false,
                data: columnDefineArray,
                onLoadSuccess: function () {
                    $.each(checkedRow, function (i, rowIndex) {
                        datalist_columnShow.datalist("checkRow", rowIndex);
                    });
                }
            });
        },
        //确认关闭按钮
        buttons: '#show_columns_buttons',
    });
}

/**
 * 选中所有要显示的列，即全选
 */
function chooseAllColumns() {
    datalist_column.datalist("checkAll");
}

/**
 * 取消全选要显示的列
 */
function unChooseAllColumns() {
    datalist_column.datalist("clearChecked");
}

/**
 * 确定要显示的列
 */

function saveChooseColumns() {
    //获取选中的列
    var checkedDataArray = datalist_column.datalist("getChecked");
    var showColumns = [];
    //自定义添加列之前要清空一下否则会出现重复拼接列头
    requesTitle.splice(0, requesTitle.length)
    //循环所有选择中的列头
    $.each(checkedDataArray, function (i, checkedData) {
        //把选中的列头放在定义的数组里面
        showColumns.push(checkedData.value);
        //把要显示的列头放进定义的集合里面，除了复选框和操作列不添加
        if (i > 1) {
            requesTitle.push(checkedData.title)
        }
        //放在前端数据库里面，key是用户id加userTitle
        localStorage.setItem(userId+"userTitle",requesTitle)
    });
    //获取所有列
    var columnFields = datagrid.datagrid("getColumnFields");
    // var hideColumn = [];
    var hiddencount = [];
    //循环所有列
    $.each(columnFields, function (i, columnField) {
        //查看所有列中是否包含要显示的列
        if ($.inArray(columnField, showColumns) != -1) {
            //包含就显示
            datagrid.datagrid("showColumn", columnField);
            if (i > 1) {
                //除了复选框和操作列默认显示，显示代表1添加到定义的集合里面
                hiddencount.push(1,);
            }
        } else {
            if (i > 1) {

                //同上，隐藏，0代表隐藏
                datagrid.datagrid("hideColumn", columnField);
                hiddencount.push(0,);
            }
        }
    });
    //把动态显示列的标记放进前端数据库
    localStorage.setItem(userId, hiddencount);
    //关闭窗口
    dialog_showColumn.window("close");
}

/**
 * 初始化列
 */

/**
 * 关闭窗口
 */
function closeShowCloumns() {
    dialog_showColumn.window("close");
}

function initShowColumnWindow2(dialog_showColumnWindow, datalist_columnShow, dg, title) {
    dialog_showColumn = dialog_showColumnWindow;
    datalist_column = datalist_columnShow;
    datagrid = dg;
    dialog_showColumnWindow.dialog({
        title: title,
        closable: true,
        collapsible: false,
        maximizable: false,
        minimizable: false,
        resizable: true,
        draggable: true,
        modal: true,
        width: 240,
        height: 400,
        onOpen: function () {
            var columnFields = dg.datagrid("getColumnFields");
            var columnDefineArray = [];
            var checkedRow = [];
            $.each(columnFields, function (i, columnField) {
                if (i > 1){
                var fieldOptions = dg.datagrid("getColumnOption", columnField);
                fieldOptions.text = fieldOptions.title;
                fieldOptions.value = columnField;
              // if (!fieldOptions.hidden) {
              //       checkedRow.push(i);
              //   }
                columnDefineArray.push(fieldOptions);
                }
            });
            datalist_columnShow.datalist({
                lines: true,
                checkbox: true,
                selectOnCheck: false,
                singleSelect: false,
                data: columnDefineArray,
              onLoadSuccess: function () {
                    $.each(checkedRow, function (i, rowIndex) {
                        datalist_columnShow.datalist("checkRow", rowIndex);
                    });
                }
            });
        },
        //确认关闭按钮
        buttons: '#show_columns_excel_buttons2',
    });
}


    excelTitle = new Array();
function saveChooseExcelColumns(){
    excelTitle.splice(0, excelTitle.length)
    var checkedDataArray = datalist_column.datalist("getChecked");

    $.each(checkedDataArray,function (i,checkedData) {
           excelTitle.push(checkedData.title);
    });
    if (excelTitle.length ==0){
        alert("请选择模板列！！！");
        return;
    }
    dialog_showColumn.window("close");
    window.location.href = "/material/excelTemplate?browserType=" + getOs()+ "&excelTitle=" + excelTitle

}

