/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.network.clientpackets.auctionhouse;

import com.l2jserver.gameserver.instancemanager.AuctionHouseManager;
import com.l2jserver.gameserver.model.actor.instance.L2PcInstance;
import com.l2jserver.gameserver.network.clientpackets.L2GameClientPacket;
import com.l2jserver.gameserver.network.serverpackets.auctionhouse.ExResponseCommissionList;

/**
 * @author Erlandys
 */
public final class RequestCommissionRegisteredItem extends L2GameClientPacket
{
	private static final String _C__D0_A3_REQUESTCOMMISSIONREGISTEREDITEM = "[C] D0:A3 RequestCommissionRegisteredItem";
	
	@Override
	protected void readImpl()
	{
	}
	
	@Override
	protected void runImpl()
	{
		final L2PcInstance player = getClient().getActiveChar();
		if (player == null)
		{
			return;
		}
		AuctionHouseManager am = AuctionHouseManager.getInstance();
		
		am.checkForAuctionsDeletion();
		
		player.sendPacket(new ExResponseCommissionList(player));
	}
	
	@Override
	public String getType()
	{
		return _C__D0_A3_REQUESTCOMMISSIONREGISTEREDITEM;
	}
}
