/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lti.itops.ipac.custcatmgmt.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapImpl;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapModelImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTechnologyCustomerMapPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the t technology customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTechnologyCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.TTechnologyCustomerMapUtil
 * @generated
 */
@ProviderType
public class TTechnologyCustomerMapPersistenceImpl extends BasePersistenceImpl<TTechnologyCustomerMap>
	implements TTechnologyCustomerMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTechnologyCustomerMapUtil} to access the t technology customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTechnologyCustomerMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByorganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByorganizationId",
			new String[] { Long.class.getName() },
			TTechnologyCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByorganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the t technology customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId) {
		return findByorganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t technology customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of t technology customer maps
	 * @param end the upper bound of the range of t technology customer maps (not inclusive)
	 * @return the range of matching t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId, int start, int end) {
		return findByorganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t technology customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of t technology customer maps
	 * @param end the upper bound of the range of t technology customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return findByorganizationId(organizationId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the t technology customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of t technology customer maps
	 * @param end the upper bound of the range of t technology customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<TTechnologyCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTechnologyCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TTechnologyCustomerMap tTechnologyCustomerMap : list) {
					if ((organizationId != tTechnologyCustomerMap.getOrganizationId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TTECHNOLOGYCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TTechnologyCustomerMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<TTechnologyCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTechnologyCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first t technology customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t technology customer map
	 * @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap findByorganizationId_First(
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = fetchByorganizationId_First(organizationId,
				orderByComparator);

		if (tTechnologyCustomerMap != null) {
			return tTechnologyCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTechnologyCustomerMapException(msg.toString());
	}

	/**
	 * Returns the first t technology customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap fetchByorganizationId_First(
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		List<TTechnologyCustomerMap> list = findByorganizationId(organizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t technology customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t technology customer map
	 * @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap findByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = fetchByorganizationId_Last(organizationId,
				orderByComparator);

		if (tTechnologyCustomerMap != null) {
			return tTechnologyCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTechnologyCustomerMapException(msg.toString());
	}

	/**
	 * Returns the last t technology customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap fetchByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		int count = countByorganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<TTechnologyCustomerMap> list = findByorganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t technology customer maps before and after the current t technology customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param TTechnologyCustomerId the primary key of the current t technology customer map
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t technology customer map
	 * @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	 */
	@Override
	public TTechnologyCustomerMap[] findByorganizationId_PrevAndNext(
		long TTechnologyCustomerId, long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = findByPrimaryKey(TTechnologyCustomerId);

		Session session = null;

		try {
			session = openSession();

			TTechnologyCustomerMap[] array = new TTechnologyCustomerMapImpl[3];

			array[0] = getByorganizationId_PrevAndNext(session,
					tTechnologyCustomerMap, organizationId, orderByComparator,
					true);

			array[1] = tTechnologyCustomerMap;

			array[2] = getByorganizationId_PrevAndNext(session,
					tTechnologyCustomerMap, organizationId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTechnologyCustomerMap getByorganizationId_PrevAndNext(
		Session session, TTechnologyCustomerMap tTechnologyCustomerMap,
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTECHNOLOGYCUSTOMERMAP_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TTechnologyCustomerMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tTechnologyCustomerMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTechnologyCustomerMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the t technology customer maps where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByorganizationId(long organizationId) {
		for (TTechnologyCustomerMap tTechnologyCustomerMap : findByorganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tTechnologyCustomerMap);
		}
	}

	/**
	 * Returns the number of t technology customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching t technology customer maps
	 */
	@Override
	public int countByorganizationId(long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTECHNOLOGYCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "tTechnologyCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_O = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_O",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_O = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_O",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTechnologyCustomerMapModelImpl.TOWERTECHNOLOGYID_COLUMN_BITMASK |
			TTechnologyCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_O = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_O",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @return the matching t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findByT_O(long towerTechnologyId,
		long organizationId) {
		return findByT_O(towerTechnologyId, organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of t technology customer maps
	 * @param end the upper bound of the range of t technology customer maps (not inclusive)
	 * @return the range of matching t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findByT_O(long towerTechnologyId,
		long organizationId, int start, int end) {
		return findByT_O(towerTechnologyId, organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of t technology customer maps
	 * @param end the upper bound of the range of t technology customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findByT_O(long towerTechnologyId,
		long organizationId, int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return findByT_O(towerTechnologyId, organizationId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of t technology customer maps
	 * @param end the upper bound of the range of t technology customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findByT_O(long towerTechnologyId,
		long organizationId, int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_O;
			finderArgs = new Object[] { towerTechnologyId, organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_O;
			finderArgs = new Object[] {
					towerTechnologyId, organizationId,
					
					start, end, orderByComparator
				};
		}

		List<TTechnologyCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTechnologyCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TTechnologyCustomerMap tTechnologyCustomerMap : list) {
					if ((towerTechnologyId != tTechnologyCustomerMap.getTowerTechnologyId()) ||
							(organizationId != tTechnologyCustomerMap.getOrganizationId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TTECHNOLOGYCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_T_O_TOWERTECHNOLOGYID_2);

			query.append(_FINDER_COLUMN_T_O_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TTechnologyCustomerMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(towerTechnologyId);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<TTechnologyCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTechnologyCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t technology customer map
	 * @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap findByT_O_First(long towerTechnologyId,
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = fetchByT_O_First(towerTechnologyId,
				organizationId, orderByComparator);

		if (tTechnologyCustomerMap != null) {
			return tTechnologyCustomerMap;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("towerTechnologyId=");
		msg.append(towerTechnologyId);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTechnologyCustomerMapException(msg.toString());
	}

	/**
	 * Returns the first t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap fetchByT_O_First(long towerTechnologyId,
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		List<TTechnologyCustomerMap> list = findByT_O(towerTechnologyId,
				organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t technology customer map
	 * @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap findByT_O_Last(long towerTechnologyId,
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = fetchByT_O_Last(towerTechnologyId,
				organizationId, orderByComparator);

		if (tTechnologyCustomerMap != null) {
			return tTechnologyCustomerMap;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("towerTechnologyId=");
		msg.append(towerTechnologyId);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTechnologyCustomerMapException(msg.toString());
	}

	/**
	 * Returns the last t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap fetchByT_O_Last(long towerTechnologyId,
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		int count = countByT_O(towerTechnologyId, organizationId);

		if (count == 0) {
			return null;
		}

		List<TTechnologyCustomerMap> list = findByT_O(towerTechnologyId,
				organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the t technology customer maps before and after the current t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * @param TTechnologyCustomerId the primary key of the current t technology customer map
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next t technology customer map
	 * @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	 */
	@Override
	public TTechnologyCustomerMap[] findByT_O_PrevAndNext(
		long TTechnologyCustomerId, long towerTechnologyId,
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = findByPrimaryKey(TTechnologyCustomerId);

		Session session = null;

		try {
			session = openSession();

			TTechnologyCustomerMap[] array = new TTechnologyCustomerMapImpl[3];

			array[0] = getByT_O_PrevAndNext(session, tTechnologyCustomerMap,
					towerTechnologyId, organizationId, orderByComparator, true);

			array[1] = tTechnologyCustomerMap;

			array[2] = getByT_O_PrevAndNext(session, tTechnologyCustomerMap,
					towerTechnologyId, organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTechnologyCustomerMap getByT_O_PrevAndNext(Session session,
		TTechnologyCustomerMap tTechnologyCustomerMap, long towerTechnologyId,
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TTECHNOLOGYCUSTOMERMAP_WHERE);

		query.append(_FINDER_COLUMN_T_O_TOWERTECHNOLOGYID_2);

		query.append(_FINDER_COLUMN_T_O_ORGANIZATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TTechnologyCustomerMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(towerTechnologyId);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tTechnologyCustomerMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTechnologyCustomerMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByT_O(long towerTechnologyId, long organizationId) {
		for (TTechnologyCustomerMap tTechnologyCustomerMap : findByT_O(
				towerTechnologyId, organizationId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tTechnologyCustomerMap);
		}
	}

	/**
	 * Returns the number of t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @return the number of matching t technology customer maps
	 */
	@Override
	public int countByT_O(long towerTechnologyId, long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_O;

		Object[] finderArgs = new Object[] { towerTechnologyId, organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTECHNOLOGYCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_T_O_TOWERTECHNOLOGYID_2);

			query.append(_FINDER_COLUMN_T_O_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(towerTechnologyId);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_T_O_TOWERTECHNOLOGYID_2 = "tTechnologyCustomerMap.towerTechnologyId = ? AND ";
	private static final String _FINDER_COLUMN_T_O_ORGANIZATIONID_2 = "tTechnologyCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TTECHNOLOGYCUSTOMERID = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTTechnologyCustomerId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTechnologyCustomerMapModelImpl.TTECHNOLOGYCUSTOMERID_COLUMN_BITMASK |
			TTechnologyCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTECHNOLOGYCUSTOMERID = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTechnologyCustomerId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTechnologyCustomerMapException} if it could not be found.
	 *
	 * @param TTechnologyCustomerId the t technology customer ID
	 * @param organizationId the organization ID
	 * @return the matching t technology customer map
	 * @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap findByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = fetchByTTechnologyCustomerId(TTechnologyCustomerId,
				organizationId);

		if (tTechnologyCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TTechnologyCustomerId=");
			msg.append(TTechnologyCustomerId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTechnologyCustomerMapException(msg.toString());
		}

		return tTechnologyCustomerMap;
	}

	/**
	 * Returns the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TTechnologyCustomerId the t technology customer ID
	 * @param organizationId the organization ID
	 * @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap fetchByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId) {
		return fetchByTTechnologyCustomerId(TTechnologyCustomerId,
			organizationId, true);
	}

	/**
	 * Returns the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TTechnologyCustomerId the t technology customer ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap fetchByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { TTechnologyCustomerId, organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TTECHNOLOGYCUSTOMERID,
					finderArgs, this);
		}

		if (result instanceof TTechnologyCustomerMap) {
			TTechnologyCustomerMap tTechnologyCustomerMap = (TTechnologyCustomerMap)result;

			if ((TTechnologyCustomerId != tTechnologyCustomerMap.getTTechnologyCustomerId()) ||
					(organizationId != tTechnologyCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TTECHNOLOGYCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTECHNOLOGYCUSTOMERID_TTECHNOLOGYCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTECHNOLOGYCUSTOMERID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTechnologyCustomerId);

				qPos.add(organizationId);

				List<TTechnologyCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TTECHNOLOGYCUSTOMERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTechnologyCustomerMapPersistenceImpl.fetchByTTechnologyCustomerId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTechnologyCustomerMap tTechnologyCustomerMap = list.get(0);

					result = tTechnologyCustomerMap;

					cacheResult(tTechnologyCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TTECHNOLOGYCUSTOMERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TTechnologyCustomerMap)result;
		}
	}

	/**
	 * Removes the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param TTechnologyCustomerId the t technology customer ID
	 * @param organizationId the organization ID
	 * @return the t technology customer map that was removed
	 */
	@Override
	public TTechnologyCustomerMap removeByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = findByTTechnologyCustomerId(TTechnologyCustomerId,
				organizationId);

		return remove(tTechnologyCustomerMap);
	}

	/**
	 * Returns the number of t technology customer maps where TTechnologyCustomerId = &#63; and organizationId = &#63;.
	 *
	 * @param TTechnologyCustomerId the t technology customer ID
	 * @param organizationId the organization ID
	 * @return the number of matching t technology customer maps
	 */
	@Override
	public int countByTTechnologyCustomerId(long TTechnologyCustomerId,
		long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TTECHNOLOGYCUSTOMERID;

		Object[] finderArgs = new Object[] { TTechnologyCustomerId, organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTECHNOLOGYCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTECHNOLOGYCUSTOMERID_TTECHNOLOGYCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTECHNOLOGYCUSTOMERID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTechnologyCustomerId);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TTECHNOLOGYCUSTOMERID_TTECHNOLOGYCUSTOMERID_2 =
		"tTechnologyCustomerMap.TTechnologyCustomerId = ? AND ";
	private static final String _FINDER_COLUMN_TTECHNOLOGYCUSTOMERID_ORGANIZATIONID_2 =
		"tTechnologyCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TOWERTECHNOLOGYID = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTowerTechnologyId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTechnologyCustomerMapModelImpl.TOWERTECHNOLOGYID_COLUMN_BITMASK |
			TTechnologyCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TOWERTECHNOLOGYID = new FinderPath(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTowerTechnologyId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTechnologyCustomerMapException} if it could not be found.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @return the matching t technology customer map
	 * @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap findByTowerTechnologyId(
		long towerTechnologyId, long organizationId)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = fetchByTowerTechnologyId(towerTechnologyId,
				organizationId);

		if (tTechnologyCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("towerTechnologyId=");
			msg.append(towerTechnologyId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTechnologyCustomerMapException(msg.toString());
		}

		return tTechnologyCustomerMap;
	}

	/**
	 * Returns the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap fetchByTowerTechnologyId(
		long towerTechnologyId, long organizationId) {
		return fetchByTowerTechnologyId(towerTechnologyId, organizationId, true);
	}

	/**
	 * Returns the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	 */
	@Override
	public TTechnologyCustomerMap fetchByTowerTechnologyId(
		long towerTechnologyId, long organizationId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { towerTechnologyId, organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TOWERTECHNOLOGYID,
					finderArgs, this);
		}

		if (result instanceof TTechnologyCustomerMap) {
			TTechnologyCustomerMap tTechnologyCustomerMap = (TTechnologyCustomerMap)result;

			if ((towerTechnologyId != tTechnologyCustomerMap.getTowerTechnologyId()) ||
					(organizationId != tTechnologyCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TTECHNOLOGYCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TOWERTECHNOLOGYID_TOWERTECHNOLOGYID_2);

			query.append(_FINDER_COLUMN_TOWERTECHNOLOGYID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(towerTechnologyId);

				qPos.add(organizationId);

				List<TTechnologyCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TOWERTECHNOLOGYID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTechnologyCustomerMapPersistenceImpl.fetchByTowerTechnologyId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTechnologyCustomerMap tTechnologyCustomerMap = list.get(0);

					result = tTechnologyCustomerMap;

					cacheResult(tTechnologyCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TOWERTECHNOLOGYID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TTechnologyCustomerMap)result;
		}
	}

	/**
	 * Removes the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @return the t technology customer map that was removed
	 */
	@Override
	public TTechnologyCustomerMap removeByTowerTechnologyId(
		long towerTechnologyId, long organizationId)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = findByTowerTechnologyId(towerTechnologyId,
				organizationId);

		return remove(tTechnologyCustomerMap);
	}

	/**
	 * Returns the number of t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	 *
	 * @param towerTechnologyId the tower technology ID
	 * @param organizationId the organization ID
	 * @return the number of matching t technology customer maps
	 */
	@Override
	public int countByTowerTechnologyId(long towerTechnologyId,
		long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TOWERTECHNOLOGYID;

		Object[] finderArgs = new Object[] { towerTechnologyId, organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTECHNOLOGYCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TOWERTECHNOLOGYID_TOWERTECHNOLOGYID_2);

			query.append(_FINDER_COLUMN_TOWERTECHNOLOGYID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(towerTechnologyId);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TOWERTECHNOLOGYID_TOWERTECHNOLOGYID_2 =
		"tTechnologyCustomerMap.towerTechnologyId = ? AND ";
	private static final String _FINDER_COLUMN_TOWERTECHNOLOGYID_ORGANIZATIONID_2 =
		"tTechnologyCustomerMap.organizationId = ?";

	public TTechnologyCustomerMapPersistenceImpl() {
		setModelClass(TTechnologyCustomerMap.class);
	}

	/**
	 * Caches the t technology customer map in the entity cache if it is enabled.
	 *
	 * @param tTechnologyCustomerMap the t technology customer map
	 */
	@Override
	public void cacheResult(TTechnologyCustomerMap tTechnologyCustomerMap) {
		entityCache.putResult(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class,
			tTechnologyCustomerMap.getPrimaryKey(), tTechnologyCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TTECHNOLOGYCUSTOMERID,
			new Object[] {
				tTechnologyCustomerMap.getTTechnologyCustomerId(),
				tTechnologyCustomerMap.getOrganizationId()
			}, tTechnologyCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TOWERTECHNOLOGYID,
			new Object[] {
				tTechnologyCustomerMap.getTowerTechnologyId(),
				tTechnologyCustomerMap.getOrganizationId()
			}, tTechnologyCustomerMap);

		tTechnologyCustomerMap.resetOriginalValues();
	}

	/**
	 * Caches the t technology customer maps in the entity cache if it is enabled.
	 *
	 * @param tTechnologyCustomerMaps the t technology customer maps
	 */
	@Override
	public void cacheResult(
		List<TTechnologyCustomerMap> tTechnologyCustomerMaps) {
		for (TTechnologyCustomerMap tTechnologyCustomerMap : tTechnologyCustomerMaps) {
			if (entityCache.getResult(
						TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TTechnologyCustomerMapImpl.class,
						tTechnologyCustomerMap.getPrimaryKey()) == null) {
				cacheResult(tTechnologyCustomerMap);
			}
			else {
				tTechnologyCustomerMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t technology customer maps.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TTechnologyCustomerMapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t technology customer map.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TTechnologyCustomerMap tTechnologyCustomerMap) {
		entityCache.removeResult(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class,
			tTechnologyCustomerMap.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TTechnologyCustomerMapModelImpl)tTechnologyCustomerMap,
			true);
	}

	@Override
	public void clearCache(List<TTechnologyCustomerMap> tTechnologyCustomerMaps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTechnologyCustomerMap tTechnologyCustomerMap : tTechnologyCustomerMaps) {
			entityCache.removeResult(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TTechnologyCustomerMapImpl.class,
				tTechnologyCustomerMap.getPrimaryKey());

			clearUniqueFindersCache((TTechnologyCustomerMapModelImpl)tTechnologyCustomerMap,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		TTechnologyCustomerMapModelImpl tTechnologyCustomerMapModelImpl) {
		Object[] args = new Object[] {
				tTechnologyCustomerMapModelImpl.getTTechnologyCustomerId(),
				tTechnologyCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TTECHNOLOGYCUSTOMERID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TTECHNOLOGYCUSTOMERID, args,
			tTechnologyCustomerMapModelImpl, false);

		args = new Object[] {
				tTechnologyCustomerMapModelImpl.getTowerTechnologyId(),
				tTechnologyCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TOWERTECHNOLOGYID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TOWERTECHNOLOGYID, args,
			tTechnologyCustomerMapModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TTechnologyCustomerMapModelImpl tTechnologyCustomerMapModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					tTechnologyCustomerMapModelImpl.getTTechnologyCustomerId(),
					tTechnologyCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTECHNOLOGYCUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTECHNOLOGYCUSTOMERID,
				args);
		}

		if ((tTechnologyCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TTECHNOLOGYCUSTOMERID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					tTechnologyCustomerMapModelImpl.getOriginalTTechnologyCustomerId(),
					tTechnologyCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTECHNOLOGYCUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTECHNOLOGYCUSTOMERID,
				args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					tTechnologyCustomerMapModelImpl.getTowerTechnologyId(),
					tTechnologyCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TOWERTECHNOLOGYID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TOWERTECHNOLOGYID,
				args);
		}

		if ((tTechnologyCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TOWERTECHNOLOGYID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					tTechnologyCustomerMapModelImpl.getOriginalTowerTechnologyId(),
					tTechnologyCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TOWERTECHNOLOGYID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TOWERTECHNOLOGYID,
				args);
		}
	}

	/**
	 * Creates a new t technology customer map with the primary key. Does not add the t technology customer map to the database.
	 *
	 * @param TTechnologyCustomerId the primary key for the new t technology customer map
	 * @return the new t technology customer map
	 */
	@Override
	public TTechnologyCustomerMap create(long TTechnologyCustomerId) {
		TTechnologyCustomerMap tTechnologyCustomerMap = new TTechnologyCustomerMapImpl();

		tTechnologyCustomerMap.setNew(true);
		tTechnologyCustomerMap.setPrimaryKey(TTechnologyCustomerId);

		tTechnologyCustomerMap.setCompanyId(companyProvider.getCompanyId());

		return tTechnologyCustomerMap;
	}

	/**
	 * Removes the t technology customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param TTechnologyCustomerId the primary key of the t technology customer map
	 * @return the t technology customer map that was removed
	 * @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	 */
	@Override
	public TTechnologyCustomerMap remove(long TTechnologyCustomerId)
		throws NoSuchTTechnologyCustomerMapException {
		return remove((Serializable)TTechnologyCustomerId);
	}

	/**
	 * Removes the t technology customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t technology customer map
	 * @return the t technology customer map that was removed
	 * @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	 */
	@Override
	public TTechnologyCustomerMap remove(Serializable primaryKey)
		throws NoSuchTTechnologyCustomerMapException {
		Session session = null;

		try {
			session = openSession();

			TTechnologyCustomerMap tTechnologyCustomerMap = (TTechnologyCustomerMap)session.get(TTechnologyCustomerMapImpl.class,
					primaryKey);

			if (tTechnologyCustomerMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTechnologyCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tTechnologyCustomerMap);
		}
		catch (NoSuchTTechnologyCustomerMapException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TTechnologyCustomerMap removeImpl(
		TTechnologyCustomerMap tTechnologyCustomerMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tTechnologyCustomerMap)) {
				tTechnologyCustomerMap = (TTechnologyCustomerMap)session.get(TTechnologyCustomerMapImpl.class,
						tTechnologyCustomerMap.getPrimaryKeyObj());
			}

			if (tTechnologyCustomerMap != null) {
				session.delete(tTechnologyCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tTechnologyCustomerMap != null) {
			clearCache(tTechnologyCustomerMap);
		}

		return tTechnologyCustomerMap;
	}

	@Override
	public TTechnologyCustomerMap updateImpl(
		TTechnologyCustomerMap tTechnologyCustomerMap) {
		boolean isNew = tTechnologyCustomerMap.isNew();

		if (!(tTechnologyCustomerMap instanceof TTechnologyCustomerMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tTechnologyCustomerMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tTechnologyCustomerMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tTechnologyCustomerMap proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TTechnologyCustomerMap implementation " +
				tTechnologyCustomerMap.getClass());
		}

		TTechnologyCustomerMapModelImpl tTechnologyCustomerMapModelImpl = (TTechnologyCustomerMapModelImpl)tTechnologyCustomerMap;

		Session session = null;

		try {
			session = openSession();

			if (tTechnologyCustomerMap.isNew()) {
				session.save(tTechnologyCustomerMap);

				tTechnologyCustomerMap.setNew(false);
			}
			else {
				tTechnologyCustomerMap = (TTechnologyCustomerMap)session.merge(tTechnologyCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TTechnologyCustomerMapModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					tTechnologyCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
				args);

			args = new Object[] {
					tTechnologyCustomerMapModelImpl.getTowerTechnologyId(),
					tTechnologyCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_T_O, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_O,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((tTechnologyCustomerMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tTechnologyCustomerMapModelImpl.getOriginalOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] {
						tTechnologyCustomerMapModelImpl.getOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}

			if ((tTechnologyCustomerMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_O.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tTechnologyCustomerMapModelImpl.getOriginalTowerTechnologyId(),
						tTechnologyCustomerMapModelImpl.getOriginalOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_T_O, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_O,
					args);

				args = new Object[] {
						tTechnologyCustomerMapModelImpl.getTowerTechnologyId(),
						tTechnologyCustomerMapModelImpl.getOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_T_O, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_O,
					args);
			}
		}

		entityCache.putResult(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTechnologyCustomerMapImpl.class,
			tTechnologyCustomerMap.getPrimaryKey(), tTechnologyCustomerMap,
			false);

		clearUniqueFindersCache(tTechnologyCustomerMapModelImpl, false);
		cacheUniqueFindersCache(tTechnologyCustomerMapModelImpl);

		tTechnologyCustomerMap.resetOriginalValues();

		return tTechnologyCustomerMap;
	}

	/**
	 * Returns the t technology customer map with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t technology customer map
	 * @return the t technology customer map
	 * @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	 */
	@Override
	public TTechnologyCustomerMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTTechnologyCustomerMapException {
		TTechnologyCustomerMap tTechnologyCustomerMap = fetchByPrimaryKey(primaryKey);

		if (tTechnologyCustomerMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTTechnologyCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tTechnologyCustomerMap;
	}

	/**
	 * Returns the t technology customer map with the primary key or throws a {@link NoSuchTTechnologyCustomerMapException} if it could not be found.
	 *
	 * @param TTechnologyCustomerId the primary key of the t technology customer map
	 * @return the t technology customer map
	 * @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	 */
	@Override
	public TTechnologyCustomerMap findByPrimaryKey(long TTechnologyCustomerId)
		throws NoSuchTTechnologyCustomerMapException {
		return findByPrimaryKey((Serializable)TTechnologyCustomerId);
	}

	/**
	 * Returns the t technology customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t technology customer map
	 * @return the t technology customer map, or <code>null</code> if a t technology customer map with the primary key could not be found
	 */
	@Override
	public TTechnologyCustomerMap fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TTechnologyCustomerMapImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TTechnologyCustomerMap tTechnologyCustomerMap = (TTechnologyCustomerMap)serializable;

		if (tTechnologyCustomerMap == null) {
			Session session = null;

			try {
				session = openSession();

				tTechnologyCustomerMap = (TTechnologyCustomerMap)session.get(TTechnologyCustomerMapImpl.class,
						primaryKey);

				if (tTechnologyCustomerMap != null) {
					cacheResult(tTechnologyCustomerMap);
				}
				else {
					entityCache.putResult(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TTechnologyCustomerMapImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTechnologyCustomerMapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tTechnologyCustomerMap;
	}

	/**
	 * Returns the t technology customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param TTechnologyCustomerId the primary key of the t technology customer map
	 * @return the t technology customer map, or <code>null</code> if a t technology customer map with the primary key could not be found
	 */
	@Override
	public TTechnologyCustomerMap fetchByPrimaryKey(long TTechnologyCustomerId) {
		return fetchByPrimaryKey((Serializable)TTechnologyCustomerId);
	}

	@Override
	public Map<Serializable, TTechnologyCustomerMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TTechnologyCustomerMap> map = new HashMap<Serializable, TTechnologyCustomerMap>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TTechnologyCustomerMap tTechnologyCustomerMap = fetchByPrimaryKey(primaryKey);

			if (tTechnologyCustomerMap != null) {
				map.put(primaryKey, tTechnologyCustomerMap);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTechnologyCustomerMapImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TTechnologyCustomerMap)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TTECHNOLOGYCUSTOMERMAP_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TTechnologyCustomerMap tTechnologyCustomerMap : (List<TTechnologyCustomerMap>)q.list()) {
				map.put(tTechnologyCustomerMap.getPrimaryKeyObj(),
					tTechnologyCustomerMap);

				cacheResult(tTechnologyCustomerMap);

				uncachedPrimaryKeys.remove(tTechnologyCustomerMap.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TTechnologyCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTechnologyCustomerMapImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the t technology customer maps.
	 *
	 * @return the t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t technology customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of t technology customer maps
	 * @param end the upper bound of the range of t technology customer maps (not inclusive)
	 * @return the range of t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the t technology customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of t technology customer maps
	 * @param end the upper bound of the range of t technology customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findAll(int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the t technology customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of t technology customer maps
	 * @param end the upper bound of the range of t technology customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of t technology customer maps
	 */
	@Override
	public List<TTechnologyCustomerMap> findAll(int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TTechnologyCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTechnologyCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TTECHNOLOGYCUSTOMERMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTECHNOLOGYCUSTOMERMAP;

				if (pagination) {
					sql = sql.concat(TTechnologyCustomerMapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TTechnologyCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTechnologyCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the t technology customer maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TTechnologyCustomerMap tTechnologyCustomerMap : findAll()) {
			remove(tTechnologyCustomerMap);
		}
	}

	/**
	 * Returns the number of t technology customer maps.
	 *
	 * @return the number of t technology customer maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTECHNOLOGYCUSTOMERMAP);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TTechnologyCustomerMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the t technology customer map persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TTechnologyCustomerMapImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TTECHNOLOGYCUSTOMERMAP = "SELECT tTechnologyCustomerMap FROM TTechnologyCustomerMap tTechnologyCustomerMap";
	private static final String _SQL_SELECT_TTECHNOLOGYCUSTOMERMAP_WHERE_PKS_IN = "SELECT tTechnologyCustomerMap FROM TTechnologyCustomerMap tTechnologyCustomerMap WHERE TTechnologyCustomerId IN (";
	private static final String _SQL_SELECT_TTECHNOLOGYCUSTOMERMAP_WHERE = "SELECT tTechnologyCustomerMap FROM TTechnologyCustomerMap tTechnologyCustomerMap WHERE ";
	private static final String _SQL_COUNT_TTECHNOLOGYCUSTOMERMAP = "SELECT COUNT(tTechnologyCustomerMap) FROM TTechnologyCustomerMap tTechnologyCustomerMap";
	private static final String _SQL_COUNT_TTECHNOLOGYCUSTOMERMAP_WHERE = "SELECT COUNT(tTechnologyCustomerMap) FROM TTechnologyCustomerMap tTechnologyCustomerMap WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tTechnologyCustomerMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTechnologyCustomerMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTechnologyCustomerMap exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TTechnologyCustomerMapPersistenceImpl.class);
}