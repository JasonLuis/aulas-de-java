
INSERT INTO TB_BOT(id_bot,name,welcome_msg,farewell_msg,downtime,default_answer) VALUES(CHATBOT_SEQ.nextval,'TheGoodBot','Bem vindo!','Até Mais',1,'Desculpe, mas não entendi');
INSERT INTO TB_BOT(id_bot,name,welcome_msg,farewell_msg,downtime,default_answer) VALUES(CHATBOT_SEQ.nextval,'The Bot Exceptional','Bem vindo!','Até Mais',1,'Desculpe, mas não entendi');
INSERT INTO TB_SEGMENT(id_segment,name,id_bot) VALUES(SEGMENT_SEQ.NEXTVAL,'Psicologia',1); 
INSERT INTO TB_SEGMENT(id_segment,name,id_bot) VALUES(SEGMENT_SEQ.NEXTVAL,'Esportes',1); 


