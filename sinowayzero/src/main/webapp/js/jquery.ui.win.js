$(document).ready(function(e){
	
	$.fn.resized = function(element){
		if(element.attr('status')=='maximized'){
			
		}else{
			element.find('.window-header .panel-tool-max').removeClass('panel-tool-normal');
		}
	};
	
	$.fn.normal = function(){	//��ԭ����
		var win = $(this).parents('.window');
		
		$('.taskbar-body ul li[appid="'+win.attr('appid')+'"]').css('background-color','#2880b4').parent().find('li.app').not($('.taskbar-body ul li[appid="'+win.attr('appid')+'"]')).css('background-color','#4b8fb7');

		win.css({'left': win.attr('win-left') + 'px', 'top': win.attr('win-top') + 'px','width':win.attr('win-width')+'px', 'height':win.attr('win-height')+'px'}).attr('status','normal').find('.window-body').css({'height':$(window).outerHeight() - 78,'width': $(window).outerWidth() - 15});;	
		
		//��ԭ���ں�����״̬��ť
		////������󻯺ͻ�ԭ��ť��ͬһ�������轫panel-tool-max��click�¼�ɾ��������������¼�ͬʱִ�У�������ͻ
		win.find('.window-header .panel-tool-normal').unbind('click').removeClass('panel-tool-normal').addClass('panel-tool-max');
		win.find('.panel-tool-max').click(function(){
			$(this).maximize();
		});
	};
	
	$.fn.maximize = function(){	//��󻯴���
		var win = $(this).parents('.window');
	
		$('.taskbar-body ul li[appid="'+win.attr('appid')+'"]').css('background-color','#2880b4').parent().find('li.app').not($('.taskbar-body ul li[appid="'+win.attr('appid')+'"]')).css('background-color','#4b8fb7');					
		win.attr('win-left', win.position().left).attr('win-top', win.position().top).attr('win-width',win.outerWidth()).attr('win-height',win.outerHeight());			
		win.css({'left':'0px','top':'0px','height':$(window).outerHeight() - 52,'width': $(window).outerWidth() - 12}).attr('status', 'maximized').find('.window-body').css({'height':$(window).outerHeight() - 78,'width': $(window).outerWidth() - 15});	
		win.find('.window-header .panel-tool-max').unbind('click').removeClass('panel-tool-max').addClass('panel-tool-normal');			
		//������󻯺ͻ�ԭ��ť��ͬһ�������轫panel-tool-max��click�¼�ɾ��������������¼�ͬʱִ�У�������ͻ
		win.find('.panel-tool-normal').click(function(){
			$(this).normal();
		});
	};
	
	$.extend({
		
		arrayDiskIcon:function(width, height){	//�Զ���������ͼ��
			var diskicon = $('.diskicon'), icons=$('.diskicon ul li');
			var n=parseInt($('.diskicon').outerHeight()/height);
			for(var i=0,len=icons.length; i<len; i++){
				icons.eq(i).css({'left':parseInt(i/n)*width+15+'px','top':i%n*height+15+'px'}).click(function(){	//����ѡ�е�ǰͼ��
					$(this).addClass('active').parent().find('li').not(this).removeClass('active');
				}).dblclick(function(){	//˫��ִ��ͼ�����
							
					//��ʼ�����ش���
					$.openWin($(this), {
						left:150,
						top:250,
						width:400,
						height:500
					});
				});	
			}
			
		},
		createAppID:function(n){	//���ɲ��ظ���appid
			var r = 0;
			while(r==0){
				r = Math.floor(Math.random()*n+1);
				//�ж�appid�Ƿ���ڣ������������������
				if($('.window[appid="'+r+'"]').attr('appid')=='underfine' || $('.window[appid="'+r+'"]').attr('appid')=='undefined' || $('.window[appid="'+r+'"]').attr('appid')==null){
					
				}else{
					r=0;
				}
			}	
				
			return r;
        },
		winActive:function (win) {	//�����
			//ȡ�������Ǽ���ڱ��������ʾ������ǰ���ڱ�����������ʾ
			//����ڿ�ǰ��ʾ�������Ǽ���ڿ�����ʾ
			$('.window').css('z-index','0').find('.window-title').css('background-color','#4b8fb7');
            win.css('z-index','9998').find('.window-title').css('background-color','#2880b4');
			//��������Ӧ��ǩ������ʾ
			$('.taskbar-body ul li[class="app"]').css('background-color','#4b8fb7').filter('[appid="' + win.attr('appid') + '"]').css('background-color','#2880b4');
			
		},
		minimize:function(win){	//��С������
			win.attr('status','minimized').hide().find('.window-title').css('background-color','#4991BC');
			$('.taskbar-body ul li[appid="'+win.attr('appid')+'"]').css('background-color','#4991BC');
		},		
		
		showWin:function(win){	//��ʾ��ǰ����
			win.show().css('z-index','9998');
			$('.window').not(win).css('z-index','0');
			$('.taskbar-body ul li[appid="'+win.attr('appid')+'"]').css('background-color','#2880b4').parent().find('li.app').not($('.taskbar-body ul li[appid="'+win.attr('appid')+'"]')).css('background-color','#4b8fb7');
		},
		hideWin:function(win){	//���ص�ǰ����
			$('.taskbar-body ul li[appid="'+win.attr('appid')+'"]').css('background-color','#4991BC');
			win.css('z-index','0').hide();
		},
		openWin:function(settings, options){		//���´���
		
			if($('.taskbar-body ul li[class="app"]').length > 5){				
				alert('�������Ѵ����ޣ�ֻ�����������6������.');
			}
			
			//��ȡJson����
			var propertyString =  eval('('+settings.attr('data-property')+')');	
			
			//�ж��Ƿ���������ظ�����
			if(propertyString.multiple == 'false' && $('.window[path="' + settings.attr('path') + '"]').length > 0){	
				return false;
			}

			
			//����AppId
			var appid = $.createAppID(9999);
			//�����������
			var win = $('<div class="panel window" appid="' + appid + '" status="'+ propertyString.winstate +'" path="' + settings.attr('path') +'"></div>');
		
			//��������ͷ������
			var windowHeader = $('<div class="panel-header panel-header-noborder window-header" style="width: 100%;"></div>');
			//�����������������
			var windowTitle = $('<div class="panel-title panel-with-icon">').append(propertyString.title).append('</div>');
			//����ͼ�����
			var windowIocn = $('<div class="panel-icon"></div>').addClass(propertyString.icon);
			//��������������
			var windowTools = $('<div class="panel-tool"></div>');
			//�����۵����߰�ť
			var toolCollapse = $('<a class="panel-tool-collapse" href="javascript:void(0)"></a>');
			windowTools.append(toolCollapse);
			
			//�ж��Ƿ����������С����ť
			if(propertyString.minimize == 'true'){
				var toolMinimize = $('<a class="panel-tool-min" href="javascript:void(0)"></a>').click(function(){
					$.minimize(win);
				});
				
				windowTools.append(toolMinimize);		
			}
			
			if(propertyString.maximize == 'true'){
				
				var normalButton = $('<span class="window-title-normal"><img src="/images/icon/16/window_normal.png" title="��ԭ" ></span>').click(function(){
					$(this).normal();
				});
				
				if(propertyString.winstate=='maximized'){		
									
					var toolNormal = $('<a class="panel-tool-normal" href="javascript:void(0)"></a>').click(function(){
						
						$(this).normal();
					});		
					
					//������ԭ��ť
					windowTools.append(toolNormal);
				}else{
					var toolMaximize = $('<a class="panel-tool-max" href="javascript:void(0)"></a>').click(function(){
						$(this).maximize();
					});		
					
					//������ԭ��ť
					windowTools.append(toolMaximize);
				}
			}else{
								
			}
			
			//�����رհ�ť			
			var toolClose = $('<a class="panel-tool-close" href="javascript:void(0)"></a>').click(function(){
				$.winClose(win);
			});
			
			windowTools.append(toolClose);
						
			windowHeader.append(windowIocn);
			windowHeader.append(windowTitle);
			windowHeader.append(windowTools);
			
			//�������ݿ�
			var winContent = $('<div class="easyui-window panel-body panel-body-noborder window-body" title="" data-options="iconCls:\'icon-save\'" style="margin-right:3px;width: 100%; height: 100%; display: block;"></div>');
			
				
			//�ƶ�����
			windowHeader.mousedown(function(event){
				$.winMove(win, event);
			});
			
			win.append(windowHeader);
			win.append(winContent);
						
			$('.window').css('z-index','0');
			win.attr('status', status)
			
			var styleString =  eval('('+ settings.attr('data-style')+')');			
			//��ȡdata-css�е���ʽ������Ϣ����ʼ������ʽ
			$.each(styleString, function(index, element){
				win.css(element.name, element.value).attr('win-'+element.name, element.value);		
			});	

			winContent.css({'height':parseInt(win.css('height')) - 25,'width':parseInt(win.css('width')) - 2});			
			
			//��ʼ�����ڵ�λ�úʹ�С
			win.css({'z-index':'9998','opacity':'0'});
			
			//���ش��嵽����
			$('body').append(win);
			
			win.fadeTo(500, 1);

			var taskbar = $('<li class="app" appid="' + appid + '" path="' + settings.attr('path')+'"><span class="taskbar-body-icon ' + propertyString.icon + '"></span><span class="taskbar-body-text">' + propertyString.title + '</span></li>').click(function(){
				$.taskbarClick($(this));
			});
			
			$('.taskbar-body ul').append(taskbar);
						
			//���ǰ���ںͶ�Ӧ��������ǩ��������ʾ
			$.winActive(win);
			
			//��������ע��Ҫͨ��iframe��ܼ���
			if(propertyString.target == 'iframe'){
				winContent.append('<iframe src="' + settings.attr('path') + '" frameborder="0" height="100%" width="100%" id="dialogFrame" scrolling="no"></iframe>');				
			}
			
			//��������ע��Ҫͨ��ajax��ǩ���
			if(propertyString.target == 'html'){
				
				$.ajax({
					type: 'get',
					url: settings.attr('path'),
					dataType: 'html',
					data: { },
					beforeSend: function (XMLHttpRequest) {
						winContent.html('<img src="/images/admin/loading.gif" />');
					},
					success: function (dataHtml, textStatus) {
						if(textStatus=='success'){
							winContent.html(dataHtml);
						}
					},
					complete: function (XMLHttpRequest, textStatus) {
						//HideLoading();
					},
					error: function (err) {
						
					}
				});
			
			}
		},
		winMove:function(win, event){			
			//������ڱ���󻯣����ƶ�ʧЧ
			if(win.attr('status') == 'maximized'){return false;}
						
			//���ǰ���ںͶ�Ӧ��������ǩ��������ʾ
			$.winActive(win);
			
			var isFlag = true;  
			//�����div���Ͻ����λ��
			var divX = event.pageX - parseInt(win.css("left")),divY = event.pageY - parseInt(win.css("top"));
			//�ƶ������¼�����̬�ı䴰��λ��
			$(document).mousemove(function (e) {  
				if (isFlag) { 
					//���岻�ܳ����������߽�
					//if(event.pageX < 0){win.css('left', '0px');}
					//���岻�ܳ������涥���߽�
					//if(event.pageY < 0){win.css('top', '0px');}
					//���岻�ܳ��������������������������޷����д���������
					//if(event.pageY > $(window).outerHeight() - $('.taskbar').height() - 10){win.css('top',($(window).outerHeight() - $('.taskbar').height()-10) + 'px');}
					//�������������λ�ÿɽ��������ƶ�����
					//if(e.pageX >0 && e.pageY>0 && e.pageY < $(window).outerHeight() - $('.taskbar').height() - 10){
					win.css({'left':e.pageX - divX, 'top':e.pageY - divY});  
					//}
					//win.fadeTo(20,0.5);
				}  
			}).mouseup(function (e) {  				
				isFlag = false; 
				//ɾ���ĵ�������ƶ��¼�
				$(document).unbind('mousemove');
				//win.fadeTo(20,1);//�ɿ�����ֹͣ�ƶ����ָ��ɲ�͸��
			});  		
		},
		winClose:function(win){	//�رմ���
			$('.taskbar-body ul li[appid="'+win.attr('appid')+'"]').remove();		
			win.remove();	
		},
		taskbarClick:function(taskbar){
			var win=$('.window[appid="'+taskbar.attr('appid')+'"]');			
			if(win.css('display')=='none'){			
				//��ԭ��ǰ����
				$.showWin(win);
			}else{
				if(win.css('z-index')=='9998'){
					$.hideWin(win);
				}else{
					$.winActive(win);
				}
			}
		},
		Init:function(){	//��ʼ������UI
			//��ֹ�Ҽ�
			$(document).bind("contextmenu",function(e){   
				//return false;   
			}).click(function(){
				
				$('.diskicon ul li').removeClass('active');
				
			});
	
			//��ʼ�������Ҳ�ͣ����λ��
			$('.dock').css('top',(($(window).outerHeight()-$('.dock').height())/2)+'px');
			
			//��ʼ������ͼ�������߶�
			$('.diskicon').css('height',($(window).outerHeight()-90)+'px');
			
			//��ʼ������ͼ������
			$.arrayDiskIcon(105, 95);
			
			$(window).resize(function(){
	
				//�����Ҳ�ͣ����λ�����ܵ���
				$('.dock').css('top',(($(window).outerHeight()-$('.dock').height())/2)+'px');
				
				//����ͼ�������߶����ܵ���
				$('.diskicon').css('height',($(window).outerHeight()-90)+'px');
				
				//����ͼ�����ܻ��Ű�
				$.arrayDiskIcon(100, 95);
			});		
		},
		resize:function(win){	//�ı䴰�ڴ�С
			var src_posi_Y = 0, dest_posi_Y = 0, move_Y = 0, is_mouse_down_Y = false, destHeight = 30, src_posi_X = 0, dest_posi_X = 0, move_X = 0,is_mouse_down_X = false,  destWidth = 30;
			
			win.find('.window-footer').mousedown(function(e){				
				src_posi_Y = e.pageY;
				is_mouse_down_Y = true;
			});
			win.find('.window-right').mousedown(function(e){				
				src_posi_X = e.pageX;
				is_mouse_down_X = true;
			});
			$(document).bind("click mouseup",function(e){
				if(is_mouse_down_Y || is_mouse_down_X){
				  is_mouse_down_Y = is_mouse_down_X = false;
				}
			}).mousemove(function(e){
				if(is_mouse_down_Y){
					dest_posi_Y = e.pageY;
					move_Y = src_posi_Y - dest_posi_Y;
					src_posi_Y = dest_posi_Y;
					destHeight = win.height() - move_Y;
					if(is_mouse_down_Y){
						win.css("height", destHeight > 30 ? destHeight : 30);
					}
				}else{					
					dest_posi_X = e.pageX;
					move_X = src_posi_X - dest_posi_X;
					src_posi_X = dest_posi_X;
					destWidth = win.width() - move_X;
					if(is_mouse_down_X){
						win.css("width", destWidth > 30 ? destWidth : 30);
					}
				}
			});
			
		}
		
	});
	
});