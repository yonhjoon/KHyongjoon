import React from 'react'
import styled from 'styled-components'
import { LoadingOutlined } from '@ant-design/icons';
import { Avatar, Space, Card } from "antd";

const ChatDisplay = ({chatDataList, isLoading}) => {
  return (
    <ChatContainer>
        {
            chatDataList.map((chat,index) => ( 
                <div key={index}>
                    {/* 질문메세지 */}
                    <Space>
                        <Avatar size={40}>Yong</Avatar>
                        <Card
                            style={{
                                width:300,

                            }}
                            bodyStyle={{
                                padding: "12px"
                            }}>
                            {chat.question}
                        </Card>
                    </Space>
                    {/* 응답메세지 */}
                    <RqeusetArea>
                        <Space>
                            <Card
                                style={{
                                    width:500,
                                    margin: "20px"

                                }}
                                bodyStyle={{
                                    padding: "12px"
                                }}>
                                {chat.message}
                            </Card>
                            <Avatar 
                                size={40} 
                                src={"https://www.irobotnews.com/news/photo/201803/13262_31414_3740.png"}
                            />
                        </Space>
                    </RqeusetArea>
                </div>
            ))
        }
        
        { isLoading && //트루 일때만 뒤쪽 UI가 보이도록-div
            <div>
                AI 응답 작성중...
                <LoadingOutlined />
            </div>
        }
        
    </ChatContainer>
  )
}

export default ChatDisplay

const RqeusetArea = styled.div`
    float: right;
    text-align: right;
`
const ChatContainer = styled.div`
    display: flex;
    flex-direction: column;
`