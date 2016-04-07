<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>Archive</h2>
<s:if test="#session.blogArchive != null">
	<s:div id="archive-links">
		<ul>
			<s:iterator value="#session.blogArchive">
				<li>
					<s:set var="year" value="key" />
					<s:a onclick="javascript:return toggleHidden('archive-year-%{key}');">
						<s:property value="#year"/>
					</s:a>
			    	<s:div id="archive-year-%{key}" style="display:none">
<!-- 							<s:iterator value="value"> -->
<!-- 									<s:set var="month" value="key" /> -->
<!-- 									<s:a onclick="javascript:return toggleHidden('archive-month-%{#year}-%{#month}');"> -->
<!-- 										<s:property value="#month"/> -->
<!-- 									</s:a> -->
<!-- 									<s:div id="archive-month-%{#year}-%{#month}" style="display:none"> -->
<!-- 											<s:iterator value="value"> -->
<!-- 													<s:property escape="false"/> -->
<!-- 											</s:iterator> -->
<!-- 									</s:div> -->
<!-- 							</s:iterator> -->
			    		<ul>
							<s:iterator value="value">
								<li>
									<s:set var="month" value="key" />
									<s:a onclick="javascript:return toggleHidden('archive-month-%{#year}-%{#month}');">
										<s:property value="#month"/>
									</s:a>
									<s:div id="archive-month-%{#year}-%{#month}" style="display:none">
										<ul>
											<s:iterator value="value">
												<li >
													<s:property escape="false"/>
												</li>
											</s:iterator>
										</ul>
									</s:div>
								</li>
							</s:iterator>
						</ul>
					</s:div>
				</li>
			</s:iterator>
		</ul>
	</s:div>
</s:if>
<s:else>
	<s:div id="empty-archive">
		<h5>
			There seems to be nothing here
		</h5>
	</s:div>
</s:else>