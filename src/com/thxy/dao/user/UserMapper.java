package com.thxy.dao.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.thxy.pojo.User;

public interface UserMapper {

	//有这句话可以不用UserMapper.xml文件，但是mybatis-config.xml的mappers需要改成<mappers><mapper class="sqlmap.UserMapper"/></mappers>	
	@Select("select * from user WHERE id=#{id}")
	public User findUserById(@Param("id") Integer id);

/*如果必须有UserMapper.xml文件，则不用写@Select文件，需要另外创一个UserMapper.xml文件，然后写代码如下：（具体参考SSMtest3-webapp）
 <mapper namespace="user">
	<select id="findUserById" parameterType="String" resultType="com.thxy.pojo.User">
		select * from user WHERE id=#{id}
	</select>
</mapper>*/
	
}