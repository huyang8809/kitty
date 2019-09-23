$(function(){
	$('#dlg-save').dialog({    
	    title: '添加用户',    
	    width: 400,
	    height: 200,    
	    closed: false,    
	    cache: false,  
	    modal: true,
	    buttons:[{
			text:'保存',
			handler:saveUsr
		}]
	});
	$('#dlg-save').dialog("close");
	
	function saveUsr(){
		var un = $("#un").val();
		var pw = $("#pw").val();
		var mail = $("#mail").val();
		$.post('ajaxSave.action',{"un":un,"pw":pw,"mail":mail},function(data){
			$('#dlg-save').dialog("close");
			$('#dg').datagrid("reload");
		});
	}
	
	//初始化表格
	$('#dg').datagrid({
		title:'用户管理',
		rownumbers:true,
		singleSelect:true,
		pagination:true,
		url:'findJson.action',
		method:'post',
		columns:[[    
	        {field:'id',title:'主键',width:100},    
	        {field:'usrname',title:'用户名',width:100},    
	        {field:'createTime',title:'创建时间',width:180,align:'right'},
	        {field:'mail',title:'电子邮箱',width:180,align:'left'}
	        
	    ]]
	});
	
	//获取并设置表格中的分页组件
	var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
	pager.pagination({
		pageList: [5,10,15,20],
		beforePageText:'第',
		afterPageText:' 页，共 {pages}页',
		displayMsg:'当前第 {from} 条到 {to} 条，共 {total} 条',
		buttons:[{
			iconCls:'icon-search',
			handler:function(){
				alert('search');
			}
		},{
			iconCls:'icon-add',
			handler:function(){
				$('#dlg-save').dialog("open");
			}
		},{
			iconCls:'icon-edit',
			handler:function(){
				var row = $('#dg').datagrid('getSelected');
				alert(row['usrname']);
			}
		}]
	});			
});