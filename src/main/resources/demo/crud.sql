update p_user set familyinfo = '{"father":{"name":"zhangsan","age":24}}' where fid = '04d2ba109b9141fc9e3ddc2ab6c0f31d';
select * from p_user where fid = '04d2ba109b9141fc9e3ddc2ab6c0f31d';
select familyinfo from p_user where fid = '04d2ba109b9141fc9e3ddc2ab6c0f31d';
select u.familyinfo from p_user u where fid = '04d2ba109b9141fc9e3ddc2ab6c0f31d';
select familyinfo::json->>'father' as father from p_user where fid = '04d2ba109b9141fc9e3ddc2ab6c0f31d';
select familyinfo::json->'father' as name from p_user where fid = '04d2ba109b9141fc9e3ddc2ab6c0f31d';
select familyinfo::json->'father'->'name' as text from p_user where fid = '04d2ba109b9141fc9e3ddc2ab6c0f31d';