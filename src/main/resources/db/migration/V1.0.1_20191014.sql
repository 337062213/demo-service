-- ----------------------------
-- DROP TABLE IF EXISTS "public"."p_group";
CREATE TABLE "public"."t_group" (
"id" varchar(48) COLLATE "default" NOT NULL,
"name" varchar(255) COLLATE "default",
"creattime" timestamp(6),
"updatetime" timestamp(6)
)
WITH (OIDS=FALSE);

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
-- ----------------------------
-- Primary Key structure for table p_group
-- ----------------------------
ALTER TABLE "public"."t_group" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Table structure for p_user
-- ----------------------------
-- DROP TABLE IF EXISTS "public"."p_user";
CREATE TABLE "public"."t_user" (
"fid" varchar(48) COLLATE "default" NOT NULL,
"name" varchar(255) COLLATE "default",
"age" int4,
"sex" varchar(1) COLLATE "default",
"address" varchar(255) COLLATE "default",
"gid" varchar(20) COLLATE "default" NOT NULL,
"creattime" timestamp(6),
"updatetime" timestamp(6)
)
WITH (OIDS=FALSE);

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table p_user
-- ----------------------------
ALTER TABLE "public"."t_user" ADD PRIMARY KEY ("fid");